package com.itask.app.dto;

public class UserDTO {
//	CREATE TABLE TBL_USER (
//		    USER_NUM NUMBER NULL,
//		    USER_ID VARCHAR2(100) NOT NULL,
//		    USER_NAME VARCHAR2(100) NOT NULL,
//		    USER_NICK VARCHAR2(100) NOT NULL,
//		    USER_PW VARCHAR2(100) NOT NULL,
//		    USER_PHONE VARCHAR2(100) NOT NULL,
//		    USER_MAIL VARCHAR2(100),
//		    USER_CERT CHAR(1) DEFAULT 'F' NULL CHECK (USER_CERT IN ('T', 'F')),
//		    USER_MONITER VARCHAR2(100) DEFAULT '0' NOT NULL,
//		    USER_AGREE VARCHAR2(100) DEFAULT 'F' NULL CHECK (USER_AGREE IN ('T', 'F')),
//		    USER_CAREER VARCHAR2(1000),
//				USER_JOIN_DATE DATE NOT NULL,
//		    CONSTRAINT USER_NUM_PK PRIMARY KEY (USER_NUM),
//		    CONSTRAINT USER_NUM_UNIQUE UNIQUE (USER_ID, USER_NICK,USER_PHONE)
//		);

	private int userNum; // pk
	private String userId; // uk
	private String userPw;
	private String userName;
	private String userNick; // uk
	private String userPhone; // uk
	private String userMail;
	private char userCert = 'F';
	private String userMoniter = "0";
	private String userAgree = "F";
	private String userCareer = "";
	private String userJoinDate;
	private String grade; // 관리자에서 출력할 때 필요
	private String badge;



	public int getUserNum() {
		return userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public char getUserCert() {
		return userCert;
	}

	public void setUserCert(char userCert) {
		this.userCert = userCert;
	}

	public String getUserMoniter() {
		return userMoniter;
	}

	public void setUserMoniter(String userMoniter) {
		this.userMoniter = userMoniter;
	}

	public String getUserAgree() {
		return userAgree;
	}

	public void setUserAgree(String userAgree) {
		this.userAgree = userAgree;
	}

	public String getUserCareer() {
		return userCareer;
	}

	public String getUserJoinDate() {
		return userJoinDate;
	}

	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getFormattedMoniter() {
		if (userMoniter == null || userMoniter.isEmpty()) {
			return "0inch 0m";
		}

		try {
			int monitorValue = Integer.parseInt(userMoniter);
			int inch = monitorValue / 100;
			int moniter = monitorValue % 100;
			return inch + "inch " + moniter + "m";
		} catch (NumberFormatException e) {
			return "Invalid format";
		}
	}

	@Override
	public String toString() {
		return "UserDTO [userNum=" + userNum + ", userId=" + userId + ", userName=" + userName + ", userNick="
				+ userNick + ", userPw=" + userPw + ", userPhone=" + userPhone + ", userMail=" + userMail
				+ ", userCert=" + userCert + ", userMoniter=" + userMoniter + ", userAgree=" + userAgree
				+ ", userCareer=" + userCareer + ", userJoinDate=" + userJoinDate + "]";
	}

}
