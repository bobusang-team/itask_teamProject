package com.itask.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;

/**
 * Servlet implementation class MainFrontController
 */
//@WebServlet("/MainFrontController")
public class MainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;

		switch (target) {
		case "/ranking/mainRank.ma": // 명예의 전당
			result = new RankingController().execute(request, response);
			break;
			
		case "bestArticles/mainBestArticles.ma": //질문 꿀팁
			result = new BestArticlesController().execute(request, response);
			break;
			
		default:
			result = new Result();
//			result.setPath("/error/404.jsp");
			result.setRedirect(false);
		}
		
		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			}else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
				
	}
}
