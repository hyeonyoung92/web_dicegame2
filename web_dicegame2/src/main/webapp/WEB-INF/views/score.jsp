<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Score View</title>
<style>
body {
	background-color: yellow;
	font-size: 13pt;
	align: center;
}
</style>
</head>

<body>

	<h2>Score</h2>
	<c:forEach var="scores" items="${scores}">
	${scores.name} : </t> ${scores.win} wins </t> ${scores.lose} loses </t> ${scores.draw} draws<br>
	</c:forEach>
<br>
	<form action="/dicegame">
		<button type="submit">Restart</button>
	</form>

 	
</body>
</html>