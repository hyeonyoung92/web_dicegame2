<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	background-color: yellow;
	font-size: 13pt;
	align: center;
}
h3 {
	color:red;
}
</style>
<body>
	<h3>결과 : ${message}</h3></br>
	${username} : ${curCellForUser}　　　AlphaDice : ${curCellForAlphaDice}

	<form action="/dicegame/scoreview">
		<button type="submit">Score</button>
	<button type="submit" name="exit" onclick="window.close();">Exit</button>
	</form>
</body>
</html>