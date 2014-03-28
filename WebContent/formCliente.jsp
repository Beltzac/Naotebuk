<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>N�otebuk</title>
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
					dayNamesMin : [ "Do", "2�", "3�", "4�", "5�", "6�", "S�" ],
					yearRange : "1930:2014"
				});
	});
</script>
<script>
	jQuery(function($) {
		$("#CPF").mask("999.999.999-99");
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
				<!-- P�gina aqui -->
				<!-- column 2 -->
				<strong><i class="glyphicon glyphicon-dashboard"></i>
					Cadastro de Cliente</strong>
				<hr>
				<div class="row">
					<form role="form">
						<div class="form-group">
							<label>Nome</label> <input type="text" class="form-control"
								name="" value="" id="">
						</div>
						<div class="form-group">
							<label>CPF</label> <input type="text" class="form-control"
								name="" value="" id="CPF">
						</div>
						<div class="form-group">
							<label>Data</label> <input type="text" class="form-control"
								id="datepicker">
						</div>
						<label>Sexo</label>
						<div class="radio">
							<label><input type="radio" name="sexo" value="m" id="">
								Masculino</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="sexo" value="f" id="">
								Feminino</label>
						</div>
						<div class="form-group">
							<label>Endere�o</label> <input type="text" class="form-control"
								name="" value="" id="">
						</div>
						<div class="form-group">
							<label>N�mero</label> <input type="text" class="form-control"
								name="" value="" id="">
						</div>
						<div class="form-group">
							<label>Cidade</label> <input type="text" class="form-control"
								name="" value="" id="">
						</div>
						<div class="form-group">
							<label>Estado</label> <select name="Estados" class="form-control">
								<option value="null">Selecione o Estado</option>
								<option value="ac">Acre</option>
								<option value="al">Alagoas</option>
								<option value="ap">Amap�</option>
								<option value="am">Amazonas</option>
								<option value="ba">Bahia</option>
								<option value="ce">Cear�</option>
								<option value="df">Distrito Federal</option>
								<option value="es">Espirito Santo</option>
								<option value="go">Goi�s</option>
								<option value="ma">Maranh�o</option>
								<option value="ms">Mato Grosso do Sul</option>
								<option value="mt">Mato Grosso</option>
								<option value="mg">Minas Gerais</option>
								<option value="pa">Par�</option>
								<option value="pb">Para�ba</option>
								<option value="pr">Paran�</option>
								<option value="pe">Pernambuco</option>
								<option value="pi">Piau�</option>
								<option value="rj">Rio de Janeiro</option>
								<option value="rn">Rio Grande do Norte</option>
								<option value="rs">Rio Grande do Sul</option>
								<option value="ro">Rond�nia</option>
								<option value="rr">Roraima</option>
								<option value="sc">Santa Catarina</option>
								<option value="sp">S�o Paulo</option>
								<option value="se">Sergipe</option>
								<option value="to">Tocantins</option>
							</select>
						</div>
						<div class="form-group">
							<label>E-mail</label> <input type="email" class="form-control"
								name="" value="" id="">
						</div>
						<br>
						<button type="submit" value="" class="btn btn-primary" />
						Cadastrar
						</button>
						<button type="submit" value="" class="btn btn-default" />
						Voltar
						</button>
					</form>
					<script type="text/javascript">
						$(function() {
							$("#datetimepicker1").datetimepicker();
						});
					</script>


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