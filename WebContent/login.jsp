<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" scope="session" class="bean.LoginBean" />
<%	if (usuario.isAutenticado()) response.sendRedirect("Controladora?action=listaPedidos"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Nãotebuk - Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>
	<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
</head>
<body>
<!-- Header -->
	<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"	data-target=".navbar-collapse">
					<span class="icon-toggle"></span>
				</button>
				<a class="navbar-brand" href="#">Nãotebuk - Login</a>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /Header -->
	<div class="container">
		<div class="row">
			<div class="col-md-5"></div>
			<!-- /col-3 -->
			<div class="col-md-5">
				<!-- Página aqui -->
				<!-- column 2 -->


				<div class="row">
					<div class="col-md-7">
						<h2>Login</h2>
						<br>
						<form id="login" method="post" action="Controladora?action=login" role="form">
							<label>E-mail:</label> 
							<input type="email" name="email" value="" class="form-control" required /> 
							<br> 
							<label>Senha:</label>
							<input type="password" name="senha" value="" class="form-control" required /> 
							<br>
							<button type="submit" value="Login" class="btn btn-primary">
							Login
							</button>
						</form>
					</div>

				</div>

			</div>
			<!--/col-span-9-->
		</div>
	</div>

</body>

<!-- /.footer -->
</html>
