package com.itask.app.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;
import com.itask.app.dao.ArticleDAO;
import com.itask.app.dto.ArticleDTO;

public class BestArticlesController{

    public Result execute(HttpServletRequest request, HttpServletResponse response){
//        데이터 처리 and jsp 전달 -> articleDAO 로 데이터 조회
    	Result result = new Result();
    	ArticleDAO articleDAO = new ArticleDAO();
    	
//    	질문과 꿀팁 게시글
    	ArticleDTO bestMoon = articleDAO.getBestArticleByType("질문");
    	ArticleDTO bestTip = articleDAO.getBestArticleByType("꿀팁");
    	
//    	요청 객체에 속성으로 추가
    	request.setAttribute("bestMoon", bestMoon);
    	request.setAttribute("bestTip", bestTip);
    	
        
        // 메인페이지로 이동
        result.setPath("/main.jsp"); //jsp 경로
        result.setRedirect(false); 
        return result; 
    }
}
