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
      <strong><i class="glyphicon glyphicon-dashboard"></i>Lista de Pedidos</strong>
		<hr>
			<div class="row">
     			<table class="table">
     				<thead>
     				<tr>
     					<th width="250px">Nome Cliente</th>
     					<th>Produto</th>
     					<th>Valor</th>
     					<th>Previsão Entrega</th>
     					<th>Link</th>
     				</tr>
     				</thead>
     				<tbody>
     				<tr class="danger">
     					<td>Pedro Atrasado</td>
     					<td>Sony VAIO Fit 14</td>
     					<td>R$ 640,50</td>
     					<td>08/03/2014</td>
     					<td><a href="#">Cadastro</a></td>
     				</tr>
     				<tr class="warning">
     					<td>Maria das Dores</td>
     					<td>Dell Inspiron 14-R</td>
     					<td>R$ 230,00</td>
     					<td>08/04/2014</td>
     					<td><a href="#">Cadastro</a></td>
     				</tr>
     				<tr>
     					<td>Pedro Pascal</td>
     					<td>Samsung Ativ Book 9</td>
     					<td>R$ 150,75</td>
     					<td>12/04/2014</td>
     					<td><a href="#">Cadastro</a></td>
     				</tr>
     				<tr>
     					<td>Joana Pereira</td>
     					<td>ASUS Vivobook</td>
     					<td>R$ 85,00</td>
     					<td>13/05/2014</td>
     					<td><a href="#">Cadastro</a></td>
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