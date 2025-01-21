package com.itask.app.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.Execute;
import com.itask.app.Result;

public class DevDetailController implements Execute{

	public Result execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int articleNum = Integer.parseInt(request.getParameter("articleNum"));
		
		DevDAO devDAO = new DevDAO();
	    ArticleListDTO dev = devDAO.selectOne(articleNum); // 특정 게시글 조회
	    request.setAttribute("dev", dev);
		
	    Result result = new Result();
	    result.setPath("/html/article/dev/askDetail.jsp");
	    result.setRedirect(false);
	    return result;
	}
}
