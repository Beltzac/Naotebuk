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
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
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
		
		$("#datepicker_2").datepicker(
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


			<div class="col-md-9">
				<!-- P�gina aqui -->
				<!-- column 2 -->
				<strong><i class="glyphicon glyphicon-dashboard"></i>
					Pesquisa de Usu�rio</strong>
				<hr>
				<div class="row">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td>
									<form action="Controladora?action=pesquisaUsuario"
										method="post">
										<label>Palavra-chave</label>
										<div class="form-group">
											<input type="text" class="form-control" name="pesquisa"
												value="" id="">
										</div>
										<button type="submit" value="" class="btn btn-primary">
											Pesquisar</button>
									</form>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Matr�cula</th>
								<th>A��o</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaUsuarios}" var="user">
								<tr>
									<td>${user.id}</td>
									<td>${user.nome}</td>
									<td>${user.email}</td>
									<td>${user.matricula}</td>
									<td><c:if test="${loginBean.gerente}"><a class="btn btn-primary btn-xs"	href="Controladora?action=editarUsuario&id=${user.id}">Editar</a></c:if></td>
								</tr>
						</tbody>
						</c:forEach>
					</table>

					<hr>
				</div>
				<div class="row"></div>
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