package com.itask.app.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;
import com.itask.app.dao.AttachfileDAO;
import com.itask.app.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.AttachfileDTO;
import com.itask.app.Execute;

public class DevDetailOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int articleNum = Integer.valueOf(request.getParameter("articleNum"));
		DevDAO devDAO = new DevDAO();
		ArticleListDTO articleListDTO = devDAO.select(articleNum); 
		Result result = new Result();

		 devDAO.increaseView(articleNum);  // 조회수 증가
		 request.setAttribute("dev", articleListDTO); 

		result.setPath("/html/article/dev/askDetail.jsp");
		result.setRedirect(false);

		return result;
	}

}
