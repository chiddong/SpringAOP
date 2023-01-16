<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- view -->


<form method="POST" action="/aop/board/addok">
	
	<table class="vertical">
		<tr>
			<th>제목</th>
			<td>${dto.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content}</td>
		</tr>
		<tr>
			<th>번호</th>
			<td>${dto.seq}</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
	</table>
	
	<div>
		<input type="button" value="돌아가기" onclick="location.href='/aop/board/list';">
		<input type="button" value="삭제하기" onclick="location.href='/aop/board/del?seq=${dto.seq}';">		
	</div>

</form>
