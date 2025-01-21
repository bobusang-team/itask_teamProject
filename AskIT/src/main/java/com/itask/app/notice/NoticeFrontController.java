package com.itask.app.notice;

public class NoticeFrontController {
	
	

}


// 아래의 내용 참고하여 만들것 ------------------------------------------------------------------
import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.UserDTO;
import com.mybatis.config.MyBatisConfig;

public class UserDAO {
   public SqlSession sqlSession;

   public UserDAO() {
      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
   }
   
   // 회원가입
   public void join(UserDTO userDTO) {
      sqlSession.insert("user.join", userDTO);
   }
   
   // 로그인
   public UserDTO login(String userId, String userPw) {
	   UserDTO userDTO = new UserDTO();
	   userDTO.setUserId(userId);
	   userDTO.setUserPw(userPw);
	   return sqlSession.selectOne("user.login", userDTO);
   }
   
}

