<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- log.jsp -->

<table class="horizontal">
	<tr>
		<th>번호</th>
		<th>시간</th>
		<th>페이지</th>
		<th>아이디</th>
	</tr>
	
	<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.seq}</td>
		<td>${dto.regdate}</td>
		<td>${dto.url}</td>
		<td>${dto.id}</td>
	</tr>
	</c:forEach>
	
</table>

