package com.itask.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.UserDTO;
import com.itask.app.member.dao.UserDAO;

public class PwresetOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		String userPw = request.getParameter("userNewPw");
		String newPwCheck = request.getParameter("userNewPwCheck");

		
		if(userPw.equals(newPwCheck)) {
			//새로 입력한 비밀번호와 재입력한 비밀번호가 일치할 때 
			//userPw update
			userDAO.reset(userPw);
			
			
		}else {
			//불일치 
			HttpSession session = request.getSession();
			session.setAttribute("pwCheckFail", "입력한 비밀번호가 불일치합니다!");
			result.setPath(request.getContextPath()+"/app/member/pwreset.jsp");
			result.setRedirect(true);
			
		}
		
		
		return null;
	}
	

}
