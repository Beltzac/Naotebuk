 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					dayNamesMin : [ "Do", "2ª", "3ª", "4ª", "5ª", "6ª", "Sá" ],
					yearRange : "1930:2014"
				});
		
		$("#datepicker_2").datepicker(
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
        <!-- Página aqui -->	
      <!-- column 2 -->	
      <strong><i class="glyphicon glyphicon-dashboard"></i> Pesquisa de Pedido</strong>
		<hr>
			<div class="row">		
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td>
							<form action="busca.jsp" method="get">
								<label>Código</label>
								<div class="form-group">
									<input type="text" class="form-control"
											name="chave" value="" id="">
								</div>
								<button type="submit" value="" class="btn btn-primary">
									Pesquisar por Código
								</button>
							</form>
							</td>
							<td>
							<form action="busca.jsp" method="get">
								<div class="form-group">
									<label>Trecho</label> <input type="text" name="chave" class="form-control">
								</div>
								<button type="submit" value="" class="btn btn-primary">
									Pesquisar por Trecho
								</button>
							</form>
							</td>
							<td>
							<form action="busca.jsp" method="get">
								<div class="form-group">
									<label>Data Inicial</label> <input type="text" class="form-control"
										name="dataIni" id="datepicker">
								</div>
								<div class="form-group">
									<label>Data Final</label> <input type="text" class="form-control"
										name="dataFin" id="datepicker_2">
								</div>
								<button type="submit" value="" class="btn btn-primary">
									Pesquisar por Período
								</button>
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
     					<th>Previsão Entrega</th>
     					<th>Link</th>
     				</tr>
     				</thead>
     				<tbody>
     				<c:forEach items="${listaConsertos}" var="pedido">
     				<tr>
     					<td>${pedido.cliente_id}</td>
     					<td>${pedido.nome}</td>
     					<td><fmt:formatNumber value="${pedido.valor}" type="currency"/></td>
     					<td>${pedido.previsao}</td>
     					<td><a href="Controladora?action=editarConserto&id=${pedido.id}">Editar</a></td>
     				</tr>
     				</tbody>
     				</c:forEach>
     			</table>	
				
				<hr>
			</div>
			<div class="row">
				<%
					if(request.getParameter("chave")!=null && !request.getParameter("chave").equals("")){
						out.print("<table class='table'>"
		     				+"<thead>"
		     					+"<tr>"
		     						+"<th width='250px'>Nome Cliente</th>"
		     						+"<th>Produto</th>"
		     						+"<th>Valor</th>"
		     						+"<th>Previsão Entrega</th>"
		     						+"<th>Link</th>"
		     					+"</tr>"
		     				+"</thead>");
						out.print("</table>");
					}
					if(request.getParameter("dataIni")!=null && request.getParameter("dataFin")!=null
							&& !request.getParameter("dataIni").equals("") && !request.getParameter("dataFin").equals("")){
						out.print("<table class='table'>"
		     				+"<thead>"
		     					+"<tr>"
		     						+"<th width='250px'>Nome Cliente</th>"
		     						+"<th>Produto</th>"
		     						+"<th>Valor</th>"
		     						+"<th>Previsão Entrega</th>"
		     						+"<th>Link</th>"
		     					+"</tr>"
		     				+"</thead>");
						out.print("</table>");
					}
				%>
			</div>
      	</div><!--/col-span-9-->
	</div>
</div>
<!-- /Main -->
  </body>
  <!-- /.footer -->
		<%@ include file="footer.jsp"%>  
  <!-- /.footer -->
</html>