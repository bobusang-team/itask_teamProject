package com.itask.app.dev;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;

/**
 * Servlet implementation class DevFrontController
 */
@WebServlet("/DevFrontController")
public class DevFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PostFrontController 실행");

        // 요청 URI에서 필요한 경로만 추출
        String target = request.getRequestURI().substring(request.getContextPath().length());

        Result result = null;

        switch (target) {
            case "/dev/list.dev": // 게시물 목록 조회
                System.out.println("게시물 목록 실행!");
                result = new DevListController().execute(request, response);
                
                break;

            case "/dev/detail.dev": // 게시물 상세 조회
                System.out.println("게시물 상세 실행!");
                result = new DevDetailController().execute(request, response);
                break;
                
            case "/dev/detailOk.dev":
    			request.getRequestDispatcher("/html/article/dev/askDetail.jsp").forward(request, response);
    			break;   
       
            case "/dev/update.dev": // 게시물 수정 화면
                System.out.println("게시물 수정 화면 실행!");
                result = new DevUpdateController().execute(request, response);
                break;

            case "/dev/updateOk.dev": // 게시물 수정 처리
                System.out.println("게시물 수정 처리 실행!");
                result = new DevUpdateOkController().execute(request, response);
                break;

            case "/dev/delete.dev": // 게시물 삭제
                System.out.println("게시물 삭제 실행!");
                result = new DevDeleteController().execute(request, response);
                break;
        }

        // 결과 처리
        if (result != null) {
            if (result.isRedirect()) {
                response.sendRedirect(result.getPath());
            } else {
                request.getRequestDispatcher(result.getPath()).forward(request, response);
            }
        }
    }

}
