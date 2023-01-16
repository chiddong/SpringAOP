<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- del.jsp -->

<form method="POST" action="/aop/board/delok">
	<input type="button" value="돌아가기" onclick="location.href='/aop/board/view?seq=${seq}';">
	
	<input type="submit" value="삭제하기">
	<input type="hidden" name="seq" value="${seq}">
</form>


