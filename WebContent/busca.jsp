 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					Pesquisa de Pedido</strong>
				<hr>
				<div class="row">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td>
									<form action="Controladora?action=pesquisaPedido" method="post">
										<label>C�digo</label>
										<div class="form-group">
											<input type="text" class="form-control" name="id" value=""
												id="">
										</div>
										<button type="submit" value="" class="btn btn-primary">
											Pesquisar por C�digo</button>
									</form>
								</td>
								<td>
									<form action="Controladora?action=pesquisaPedido" method="post">
										<div class="form-group">
											<label>Trecho</label> <input type="text" name="pesquisa"
												class="form-control">
										</div>
										<button type="submit" value="" class="btn btn-primary">
											Pesquisar por Trecho</button>
									</form>
								</td>
								<td>
									<form action="Controladora?action=pesquisaPedido" method="post">
										<div class="form-group">
											<label>Data Inicial</label> <input type="text"
												class="form-control" name="data1" id="datepicker">
										</div>
										<div class="form-group">
											<label>Data Final</label> <input type="text"
												class="form-control" name="data2" id="datepicker_2">
										</div>
										<button type="submit" value="" class="btn btn-primary">
											Pesquisar por Per�odo</button>
									</form>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="table">
						<thead>
							<tr>
								<th width="250px">ID Cliente</th>
								<th>Produto</th>
								<th>Valor</th>
								<th>Previs�o Entrega</th>
								<th>Link</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaConsertos}" var="pedido">
								<tr>
									<td>${pedido.cliente_id}</td>
									<td>${pedido.nome}</td>
									<td><fmt:formatNumber value="${pedido.valor}"
											type="currency" /></td>
									<td>${pedido.previsao}</td>
									<td><a
										href="Controladora?action=editarConserto&id=${pedido.id}">Editar</a></td>
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