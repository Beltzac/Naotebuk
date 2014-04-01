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
      <strong><i class="glyphicon glyphicon-dashboard"></i> Lista de Pedidos</strong>
		<hr>
			<div class="row">
     			<table class="table">
     				<thead>
     				<tr>
     					<th width="250px">Nome Cliente</th>
     					<th>Produto</th>
     					<th>Valor</th>
     					<th>Data do Conserto</th>
     					<th>Pagamento</th>
     				</tr>
     				</thead>
     				<tbody>
     				<tr>
     					<td>Marcos João</td>
     					<td>Sony VAIO Fit 14</td>
     					<td>R$ 140,25</td>
     					<td>09/03/2014</td>
     					<td><a href="#">Marcar como Pago</a></td>
     				</tr>
     				<tr>
     					<td>Ana Lúcia</td>
     					<td>Dell Inspiron 14-R</td>
     					<td>R$ 250,00</td>
     					<td>14/04/2014</td>
     					<td><a href="#">Marcar como Pago</a></td>
     				</tr>
     				</tbody>
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