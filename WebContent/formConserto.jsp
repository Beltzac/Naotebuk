<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Nãotebuk</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker(
				{
					changeMonth : true,
					changeYear : true,
					dateFormat : "dd/mm/yy",
					monthNamesShort : [ "Jan", "Fev", "Mar", "Abr", "Mai",
							"Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez" ],
					dayNamesMin : [ "Do", "2ª", "3ª", "4ª", "5ª", "6ª", "Sá" ],
					yearRange : "1930:2014"
				});
	});
</script>
<script>
	jQuery(function($) {
		$("#price").mask("R$ 9999,99");
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
					Pedido de Conserto</strong>
				<hr>
				<div class="row">
					<form role="form">
						<div class="form-group">
							<label>Cliente</label> <input type="text" class="form-control"
								name="" value="" id="">
						</div>
						<div class="form-group">
							<label>Nome do Produto</label> <input type="text"
								class="form-control" name="" value="" id="">
						</div>
						<div class="form-group">
							<label>Modelo do Produto</label> <input type="text"
								class="form-control" name="" value="" id="">
						</div>
						<label>Tipo do Produto</label>
						<div class="radio">
							<label><input type="radio" name="sexo" value="m" id="">
								Desktop</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="sexo" value="f" id="">
								Notebook</label>
						</div>
						<div class="form-group">
							<label>Fabricante</label> <input type="text" class="form-control"
								name="" value="" id="">
						</div>
						<div class="form-group">
							<label>Problema</label>
							<textarea class="form-control" rows="5"></textarea>
						</div>
						<div class="form-group">
							<label>Data</label> <input type="text" class="form-control"
								name="" value="" id="datepicker">
						</div>
						<div class="form-group">
							<label>Preço</label> <input type="text" class="form-control"
								name="" value="" id="price">
						</div>
						<br>
						<button type="submit" value="" class="btn btn-primary" />
						Cadastrar
						</button>
						<button type="submit" value="" class="btn btn-default" />
						Voltar
						</button>

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