package com.itask.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.AttachfileDTO;
import com.mybatis.config.MyBatisConfig;

public class AttachfileDAO {
SqlSession sqlSession;
	
	public AttachfileDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(AttachfileDTO AttachfileDTO) {
		sqlSession.insert("attach.insert", AttachfileDTO);
	}
	
	public List<AttachfileDTO> select(int articleNum) {
		return sqlSession.selectList("file.select", articleNum);
	}
	
	public void delete(int articleNum) {
		sqlSession.delete("attach.delete", articleNum);
	}
}

