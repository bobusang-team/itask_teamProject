package com.itask.app.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;
import com.itask.app.dao.DevDAO;

public class DevModifyController {

	public Result execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		int articleNum = Integer.valueOf(request.getParameter("articleNum"));
		DevDAO devDAO = new DevDAO();
		
		request.setAttribute("dev", devDAO.select(articleNum));
		
		request.getRequestDispatcher("/app/board/boardUpdate.jsp").forward(request, response);
		return null;
	}

}
