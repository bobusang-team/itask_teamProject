package com.itask.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.UserDTO;
import com.mybatis.config.MyBatisConfig;

public class UserDAO {
	
//	명전 상위 5명 가져오기 
	public List<UserDTO> getRankingTop5() {
		List<UserDTO> users = new ArrayList<>();
		
//		db연결
		String sql = "SELECT USER_NUM, USER_ID, USER_NICK, "
					+ "USER_CAREER FROM TBL_USER ORDER BY TO_NUMBER(USER_MONITER) DESC FETCH FIRST 5 ROWS ONLY";
		
		try (Connection conn = DriverManager.getConnection("jdbc_url","username","password");
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery()) {
			
			
			while (rs.next()) {
				UserDTO user = new UserDTO();
				user.setUserNum(rs.getInt("USER_NUM"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setUserNick(rs.getString("USER_NICK"));
				users.add(user);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
		
	}
	
}
