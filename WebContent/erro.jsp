<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Erro!</title>
</head>
<body>
	<h1>=(</h1>
	<h2>${mensagem}</h2><br>
	<a href="${voltar}">Voltar</a><br>
	<hr>
	${stacktrace}
</body>
</html>