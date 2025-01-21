package com.itask.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.AdminDTO;
import com.itask.app.dto.NoticeDTO;

public class WriteController implements Execute {
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		AdminDTO adminDTO = new AdminDTO();
		NoticeDTO noticeDTO = new  NoticeDTO(); 
		Result result = new Result();
		
		
		System.out.println(adminDTO);
		System.out.println(noticeDTO);
		noticeDTO.setNoticeCategory(request.getParameter("noticeCategory"));
		noticeDTO.setNoticeTitle(request.getParameter("noticeTitle"));
		noticeDTO.setNoticeText(request.getParameter("noticeText"));
		noticeDTO.setNoticeView(request.getParameter("noticeView"));
		noticeDTO.setAdminNUm(adminDTO.getAdminNum());
		
		adminDAO.write(noticeDTO);		

		result.setRedirect(true);
		result.setPath("/app/admin/notice.ad");
		return result;
	}

}
