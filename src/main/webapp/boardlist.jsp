<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
      <%@ taglib prefix="c" uri="jakarta.tags.functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글목록</title>
</head>
<body>

	<h2>게시판 글목럭</h2>
	<hr>
	<table border="1" width="800">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>미멜</th>
			<th>조회수</th>
			<th>작성일</th>
		
		
		
		</tr>
	
	
	</thead>
	
	<tbody>
	<c:forEach var="Bdto" items="${boardlist }">
	<tr>
			<td>${BDto.boardnum }</td>
			<td>
			<a href=""boardView.do?boardnum=${BDto.boardnum }">
			</a></td>
			<td>${BDto.username }</td>
			<td>${BDto.email }</td>
			<td>${BDto.hit }</td>
			<td>${BDto.regdate }</td>
		
		
		
		</tr>
	</c:forEach>
	
	
	
	
	</tbody>
	
	
	</table>

<button type="button" onclik="location.href='boardWrite.do'">글쓰기</button>
</body>
</html>