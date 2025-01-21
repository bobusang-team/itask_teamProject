package com.itask.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.ArticleDTO;
import com.mybatis.config.MyBatisConfig;

public class ArticleDAO {

	//타입별로 글 가져옴
	 public ArticleDTO getBestArticleByType(String type) {
	        ArticleDTO article = null;
	        
	        String sql = "SELECT * FROM TBL_ARTICLE WHERE ARTICLE_BOTCATE = ? ORDER BY ARTICLE_MONITER_NUM DESC LIMIT 1";
	        
	        try (Connection conn = DriverManager.getConnection("jdbc_url", "username", "password");
	             PreparedStatement psmt = conn.prepareStatement(sql)) {
	            
	            psmt.setString(1, type); // type을 쿼리에 바인딩
	            try (ResultSet rs = psmt.executeQuery()) {
	                if (rs.next()) {
            article = new ArticleDTO();
            article.setArticleTitle(rs.getString("ARTICLE_TITLE"));
			article.setArticledate(rs.getString("ARTICLE_DATE"));
			article.setUserNum(rs.getInt("USER_NUM"));
			article.setArticleNum(rs.getInt("ARTICLE_NUM"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return article;
	}

	 }
}
