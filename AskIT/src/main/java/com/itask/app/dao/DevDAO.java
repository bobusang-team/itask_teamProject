package com.itask.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.ArticleDetailDTO;
import com.itask.app.dto.ArticleListDTO;
import com.mybatis.config.MyBatisConfig;

public class DevDAO {

	public SqlSession sqlSession;

	public DevDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
		
    //모든 게시글 가져오기
	public List<ArticleListDTO> selectAll(Map<String, Integer> pageMap) {
	    System.out.println("DAO selectAll 실행");
	    System.out.println("pageMap: " + pageMap);
		List<ArticleListDTO> list = sqlSession.selectList("dev.selectAll", pageMap);
		System.out.println("조회 결과: " + list);
		return list;
	}
	
    // 게시글 총 개수 가져오기
	public int getTotal() {
		return sqlSession.selectOne("dev.getTotal");
	}
	
    //조회수 증가
	public void increaseView(int articleNum) {
		sqlSession.update("dev.increaseView", articleNum);
	}
	
	//게시글 삭제
	public void delete(int articleNum) {
		sqlSession.delete("dev.delete", articleNum);
	}
	
	//게시글 수정
	public void update(ArticleDetailDTO articleDetailDTO) {
		sqlSession.update("dev.update", articleDetailDTO);
	}

	
	public ArticleListDTO selectOne(int articleNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("dev.selectOne", articleNum);
	}
	public ArticleListDTO select(int articleNum) {
		return sqlSession.selectOne("dev.select", articleNum);
	}




    
    
    
}
