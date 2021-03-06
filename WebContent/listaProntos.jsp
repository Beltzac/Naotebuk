 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="utf-8">
    <title>N�otebuk - Pedidos</title>
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
        <!-- P�gina aqui -->	
      <!-- column 2 -->	
      <strong><i class="glyphicon glyphicon-dashboard"></i> Lista de Pedidos Prontos</strong>
		<hr>
			<div class="row">
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
     				<c:forEach items="${listaProntos}" var="pedido">
     				<tr>
     					<td>${pedido.cliente_id}</td>
     					<td>${pedido.nome}</td>
     					<td><fmt:formatNumber value="${pedido.valor}" type="currency"/></td>
     					<td><fmt:formatDate value="${pedido.previsao}" pattern="dd/MM/yyyy"/></td>
     					<td><a class="btn btn-primary btn-xs" href="Controladora?action=editarConserto&id=${pedido.id}">Editar</a>
     						<a class="btn btn-success btn-xs" href="Controladora?action=pago&id=${pedido.id}" onClick="confirm('Deseja realizar essa a��o?')">Pago</a>
     					</td>
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