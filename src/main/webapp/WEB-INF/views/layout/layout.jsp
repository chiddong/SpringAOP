<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring AOP</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

	header > div {
		text-align: center;
		background-color: #EFEFEF;
	}

</style>
</head>
<body>
	
	<!-- layout.jsp -->	
	<header>
		<h1>Spring AOP</h1>
		<div>
			<c:if test="${empty auth}">
				<a href="/aop/member/login">로그인</a>
			</c:if>
			
			<c:if test="${not empty auth }">
			<a href="/aop/member/logout">로그아웃(${name}, ${auth}, ${lv})</a>
			</c:if>
			
			<a href="/aop/board/list">게시판</a>
			
			<c:if test="${not empty auth and lv == 2}">
			<a href="/aop/member/log">로그</a>
			</c:if>
			
		</div>	
	</header>
	
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
	
	<script>
		
		
	
	</script>	

</body>
</html>