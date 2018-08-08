<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
* {
	box-sizing: border-box;
}

.menu {
	float: left;
	width: 20%;
	text-align: center;
}

.menu a {
	background-color: #e5e5e5;
	padding: 8px;
	margin-top: 7px;
	display: block;
	width: 100%;
	color: black;
}

.main {
	float: left;
	width: 60%;
	padding: 0 20px;
}

.right {
	background-color: #e5e5e5;
	float: left;
	width: 20%;
	padding: 15px;
	margin-top: 7px;
	text-align: center;
}

h1 {
	color: #fcfcfc;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th, td {
	text-align: center;
	padding: 8px;
}

@media only screen and (max-width:620px) {
	/* For mobile phones: */
	.menu, .main, .right {
		width: 100%;
	}
}
</style>
</head>
<body style="font-family: Verdana">

	<div
		style="background-color: #00a4f7; padding: 15px; text-align: center;">
		<h1>BLUE</h1>
	</div>

	<div style="overflow: auto">
		<div class="menu">
			<a href="#">Pagamentos</a>
		</div>

		<div class="main">
			<h3>Mensagem do sistema</h3>
			<p>${message}</p>			
		</div>

		<div class="right">
			<h2>Suporte</h2>
			<p>flavio.santos@flawell.com</p>
			<p>+55 (11) 4349-6238</p>
			<p>+32 471257873</p>
		</div>
	</div>

	<div
		style="background-color: #e5e5e5; text-align: center; padding: 10px; margin-top: 7px;">©
		copyright Lorius Solutions</div>

</body>
</html>
