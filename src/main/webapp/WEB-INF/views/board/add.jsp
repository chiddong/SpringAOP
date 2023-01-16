<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- add.jsp -->


<form method="POST" action="/aop/board/addok">
	
	<table class="vertical">
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" required class="full"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" required class="full"></textarea></td>
		</tr>
	</table>
	
	<div>
		<input type="button" value="돌아가기" onclick="location.href='/aop/board/list';">
		<input type="submit" value="쓰기">
	</div>

</form>



