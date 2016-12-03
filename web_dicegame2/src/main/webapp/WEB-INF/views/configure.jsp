<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Configure</title>
<style>
body {
	background-color: yellow;
	font-size: 13pt;
	font-weight: strong;
	align: center;
}
h3{
	color:red;
}
</style>
</head>
<body>
	<h3>Configure</h3>
	<h5>(modify the faceCell's amount)</h5>
	<form id="configure" action="/dicegame/setconfigure" method="post">
		<input type="text" name="beforeCell" /> -> <input type="text"
			name="afterCell" />
		<button type="submit">Modify</button>
	</form>
	<form action="/dicegame/initconfigure" method="post">
		<button type="submit">Basic</button>
	</form>

	<form action="/dicegame" method="get">
		<button type="submit">Okay</button>
	</form>
	<h3>[Check the faceCells]</h3>
	<c:forEach var="i" begin="1" end="29" step="1">
  
      ${i} 의 셀에서 ${afterCells[i]}로 이동! </br>
	
	</c:forEach>
</body>
</html>