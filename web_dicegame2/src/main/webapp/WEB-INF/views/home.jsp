<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Dice Game</title>
<style>
body {
	background-color: yellow;
	font-size: 13pt;
	font-weight: strong;
	align: center;
}
</style>
</head>
<body>
	<h3>HY's DiceGame</h3>

	<form name="startGame" action="/dicegame/play" method="post">
		<input type="text" name="username" id="username" required="" />&nbsp;&nbsp;
		<button type="submit">play</button>
	</form>
	<br>
	<!-- <a href="/">configure</a>-->
	<!--<button type="submit"><a href="/">configure</a></button> -->
	<form action="/dicegame/configurehome">
		<button type=submit>configure</button>
	</form>
	<input type="submit" name="exit" onclick="window.close();" value="Exit" />
</body>
</html>
