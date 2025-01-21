<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.itask.app.dto.AdminDTO" %>
	<header class="adminheader">
        <div class="header-container">
          <!-- 로고 -->
          <div class="header-brand">
            <img src="${pageContext.request.contextPath}/assets/img/logo/logo_b.png" alt="ITASK 로고" class="header-logo">
          </div>
          <!-- 검색 및 글쓰기 -->
          <div class="search-container">
            <div class="search-wrapper">
              <input type="text" class="search-input" placeholder="키워드를 입력하세요">
              <button class="search-button">
                <img src="${pageContext.request.contextPath}/assets/img/readingGlass.png" alt="검색 아이콘">
              </button>
            </div>
            <a href="${pageContext.request.contextPath}/app/admin/write.ad" class="write-button" target="main">
              <img src="${pageContext.request.contextPath}/assets/img/File Plus 02.png" alt="글쓰기 아이콘">
              글쓰기
            </a>
          </div>
          <div class="admin-info">
            <%@ page session="true" %>
			<%
			    AdminDTO userInfo = (AdminDTO)session.getAttribute("adminDTO");
			
			
			    if (userInfo != null) {
			        String adminNick = userInfo.getAdminNick();
			        
			%>
			    <script>
			    
			        sessionStorage.setItem('adminNick', '<%= adminNick %>');
			        document.write(userNick);
			    </script>
			<%
			    } else {
			%>
			    <script>
			        let userNick = sessionStorage.getItem('adminNick');
			        
			        if (userNick) {
			        	document.write(userNick);
			        } else {
			           	location.href = "${pageContext.request.contextPath}/app/admin/adminLogin.jsp";
			        }
			    </script>
			<%
			    }
			%>
            <a href="${pageContext.request.contextPath}/app/admin/logout.ad" class="logout-link" target="main">로그아웃</a>
          </div>
        </div>
      </header>
    
      <!-- 네비게이션 -->
      <nav class="navbar">
        <ul class="navbar-menu">
          <!-- 회원관리 -->
          <li class="menu-item">
            <a href="#" class="menu-link">회원관리</a>
            <div class="submenu">
              <a href="#" class="submenu-link">블랙리스트</a>
              <a href="${pageContext.request.contextPath}/admin/basic/totalMember.ad" target="main" class="submenu-link" id="total">전체회원</a>
              <a href="${pageContext.request.contextPath}/app/admin/generalMember.ad" target="main" class="submenu-link" id="general">일반회원</a>
              <a href="${pageContext.request.contextPath}/app/admin/mentoMember.ad" target="main" class="submenu-link" id="mento">멘토회원</a>
            </div>
          </li>
          <!-- 공지게시판 -->
          <li class="menu-item">
            <a href="#" class="menu-link">공지게시판</a>
            <div class="submenu">
              <a href="${pageContext.request.contextPath}/app/admin/notice.ad" target="main" class="submenu-link" id="notice">공지게시판 목록</a>
            </div>
          </li>
          <!-- 꿀팁게시판 -->
          <li class="menu-item">
            <a href="#" class="menu-link">꿀팁게시판</a>
            <div class="submenu">
              <a href="${pageContext.request.contextPath}/app/admin/tipDev.ad" target="main" class="submenu-link">개발</a>
              <a href="${pageContext.request.contextPath}/app/admin/tipSec.ad" target="main" class="submenu-link">보안</a>
              <a href="${pageContext.request.contextPath}/app/admin/tipQual.ad" target="main" class="submenu-link">자격증</a>
            </div>
          </li>
          <!-- 질문게시판 -->
          <li class="menu-item">
            <a href="#" class="menu-link">질문게시판</a>
            <div class="submenu">
              <a href="${pageContext.request.contextPath}/app/admin/askDev.ad" target="main" class="submenu-link">개발</a>
              <a href="${pageContext.request.contextPath}/app/admin/askSec.ad" target="main" class="submenu-link">보안</a>
              <a href="${pageContext.request.contextPath}/app/admin/askQual.ad" target="main" class="submenu-link">자격증</a>
            </div>
          </li>
        </ul>
      </nav>
