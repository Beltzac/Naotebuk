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
				<strong><i class="glyphicon glyphicon-dashboard"></i> Relatórios</strong>
				<hr>
				<div class="row">
					<form role="form" method="POST" action="Relatorio">
						<input type='radio' name='option' value='atrasado' checked> Atrasados <br /> 
					    <input type='radio' name='option' value='retirar'> A serem retirados <br /><br> 
					<button type="submit" value="" class="btn btn-primary" >Gerar</button>
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