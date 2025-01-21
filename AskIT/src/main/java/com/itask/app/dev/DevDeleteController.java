package com.itask.app.dev;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;
import com.itask.app.dao.DevDAO;

public class DevDeleteController {

	public Result execute(HttpServletRequest request, HttpServletResponse response) {
		DevDAO devDAO = new DevDAO();
		Result result = new Result();
		int articleNum = Integer.valueOf(request.getParameter("articleNum"));
		
		devDAO.delete(articleNum);
		result.setPath("/board/devList.dev");
		result.setRedirect(true);
		return result;
	}

}
