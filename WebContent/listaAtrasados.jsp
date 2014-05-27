 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="utf-8">
    <title>Nãotebuk - Pedidos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="css/bootstrap.min.css" rel="stylesheet">
  	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>
	<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
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
      <strong><i class="glyphicon glyphicon-dashboard"></i> Lista de Pedidos Atrasados</strong>
		<hr>
			<div class="row">
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
     				<c:forEach items="${listaAtrasados}" var="pedido">
     				<tr>
     					<td>${pedido.cliente_id}</td>
     					<td>${pedido.nome}</td>
     					<td><fmt:formatNumber value="${pedido.valor}" type="currency"/></td>
     					<td>${pedido.previsao}</td>
     					<td><a href="Controladora?action=editarConserto7id=${pedido.id}">Editar</a></td>
     				</tr>
     				</tbody>
     				</c:forEach>
     			</table>
			
			
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