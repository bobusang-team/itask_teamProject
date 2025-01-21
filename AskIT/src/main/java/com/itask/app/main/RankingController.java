package com.itask.app.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;
import com.itask.app.dao.UserDAO;
import com.itask.app.dto.UserDTO;


public class RankingController{

	public Result execute(HttpServletRequest request, HttpServletResponse response) {
		
		UserDAO UserDAO = new UserDAO(); 
		
		List<UserDTO> topUsers = UserDAO.getRankingTop5();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//json으로 변환하고 나서 응답
		String json = new Gson().toJson(topUsers);
		response.getWriter().write(json);
	}

}
