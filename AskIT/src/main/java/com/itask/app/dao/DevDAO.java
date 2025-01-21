package com.itask.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


import com.itask.app.dto.ArticleListDTO;
import com.mybatis.config.MyBatisConfig;

public class DevDAO {

	public SqlSession sqlSession;

	public DevDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
		
    //모든 게시글 가져오기
	public List<ArticleListDTO> selectAll(Map<String, Integer> pageMap) {
		List<ArticleListDTO> list = sqlSession.selectList("dev.selectAll", pageMap);
		return list;
	}
	

    
    // 게시물 삭제
    public boolean deleteArticle(int articleNum) {
        try {
            int result = sqlSession.delete("dev.deleteArticle", articleNum);
            return result > 0; // 성공 여부 반환
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 실패 시 false 반환
        }
    }
    
    // 게시물 수정
    public boolean modifyArticle(ArticleListDTO articleDTO) {
        try {
            int result = sqlSession.update("dev.update", articleDTO);
            return result > 0; // 성공 여부 반환
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 실패 시 false 반환
        }
    }
    
    // 게시물 조회수 증가
    public boolean increaseView(int articleNum) {
        try {
            int result = sqlSession.update("dev.increaseView", articleNum);
            return result > 0; // 성공 여부 반환
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 실패 시 false 반환
        }
    }
    
    // 게시글 총 개수 가져오기
	public int getTotal() {
		return sqlSession.selectOne("dev.getTotal");
	}

	public ArticleListDTO selectOne(int articleNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("dev.selectOne", articleNum);
	}
	public ArticleListDTO select(int articleNum) {
		return sqlSession.selectOne("dev.select", articleNum);
	}




    
    
    
}
