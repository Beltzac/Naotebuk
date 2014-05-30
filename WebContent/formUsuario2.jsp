<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Nãotebuk - Cadastro de Usuário</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>
	<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<script>
	jQuery(function($) {
		$("#mat").mask("9999-99");
	});
</script>
</head>

<body>
	<!-- Header -->
	<%@ include file="header.jsp"%>
	<!-- /Header -->

	<!-- Main -->
	<div class="container">
		<div class="row">

			<!-- Left column -->
			<%@ include file="menuEsquerda.jsp"%>

			<div class="col-md-6">
				<!-- Página aqui -->
				<!-- column 2 -->
				<strong><i class="glyphicon glyphicon-dashboard"></i>
					Cadastro de Usuário</strong>
				<hr>
				<div class="row">
					<form role="form" method="POST" action="Controladora?action=novoUsuario">
					<div class="form-group">
					<label>Nome</label>
					<input type="text" class="form-control" name="nome" value="${usuario.nome}" id="" required>
					</div>
					<div class="form-group">
					<label>E-mail</label>
					<input type="email" class="form-control" name="email" value="${usuario.email}" id="" required>
					</div>
					<div class="form-group">
					<label>Matrícula</label>
					<input type="text" class="form-control" name="matricula"  value="${usuario.matricula}" id="mat" required>
					</div>
					<label>Cargo</label>
					<div class="radio">	
					<label><input type="radio" name="gerente" value="0" id=""> Técnico</label>
					</div>
					<div class="radio">
					<label><input type="radio" name="gerente" value="1" id=""> Gerente</label>
					</div>
					<div class="form-group">
					<label>Senha</label>
					<input type="password" class="form-control" name="senha" value="" id="" required>
					</div>
					<div class="form-group">
					<label>Digite sua senha novamente</label>
					<input type="password" class="form-control" name="senha2" value="" id="" required>
					</div>
					<br>
					<button type="submit" value="" class="btn btn-primary" >Atualizar</button>
					<button type="submit" value="" class="btn btn-default" >Voltar</button>
				</form>



				</div>




			</div>
			<!--/col-span-9-->
		</div>
	</div>
	<!-- /Main -->
</body>
<!-- /.footer -->
<%@ include file="footer.jsp"%>
<!-- /.footer -->
</html>