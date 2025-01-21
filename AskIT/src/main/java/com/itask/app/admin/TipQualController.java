package com.itask.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.ArticleDTO;

public class TipQualController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 AdminDAO adminDAO = new AdminDAO();
	        
	        // 전체 회원 목록 가져오기
	        List<ArticleDTO> tipQual = adminDAO.TipQual();

	        // 회원 목록을 request 객체에 담아 JSP로 전달
	        request.setAttribute("tipQual", tipQual);

	        // 결과 페이지 설정
	        Result result = new Result();
	        result.setPath("/app/admin/tipQual.jsp");
	        return result;
	}



}
