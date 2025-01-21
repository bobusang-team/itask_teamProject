package com.itask.app.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dao.DevDAO;
import com.itask.app.dto.ArticleDetailDTO;

public class DevUpdateOkController implements Execute{

	public Result execute(HttpServletRequest request, HttpServletResponse response) 
			
		throws IOException, ServletException {
		DevDAO devDAO = new DevDAO();
		ArticleDetailDTO articleDetailDTO = new ArticleDetailDTO();
		Result result = new Result();
		
			
			
		
		return null;
	}

}
