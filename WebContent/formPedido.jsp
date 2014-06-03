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
	<script type="text/javascript" src="js/jquery.maskMoney.js"></script>
	<script>
		 $(function() {
			$( "#datepicker" ).datepicker({
				changeMonth: true,
				changeYear: true,
				dateFormat: "dd/mm/yy",
				monthNamesShort: [ "Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"],
				dayNamesMin: [ "Do", "2ª", "3ª", "4ª", "5ª", "6ª", "Sá" ],
				yearRange: "1930:2014"
			});
		});
	</script>
	<script>
	  $(function() {
	    $('#valor').maskMoney();
	  })
	</script>
	<!--<script>
		jQuery(function($){
			$("#price").mask("R$ 9999,99");
		});
	</script>-->
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
					Cadastro de Conserto</strong>
				<hr>
				<div class="row">
					<form role="form" method="POST" action="Controladora?action=novoPedido">
						<div class="form-group">
							<label>Cliente</label> 
							<!-- <input type="text" class="form-control" name="cliente_id" value="" id="" required> -->
							<select class="form-control"  name="cliente_id">
										<c:forEach items="${listaClientes}" var="item"  varStatus="cont">      
	        	                            <option value="${item.id}">${item.nome}</option>  
    	    							 </c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Nome do Produto</label> 
							<input type="text" class="form-control" name="nome" value="" id="" required>
						</div>
						<div class="form-group">
							<label>Modelo do Produto</label> 
							<input type="text" class="form-control" name="modelo" value="" id="" required>
						</div>
						<label>Tipo do Produto</label>
						<div class="radio">
							<label><input type="radio" name="tipo" value="0" id="">	Desktop</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="tipo" value="1" id="">	Notebook</label>
						</div>
						<div class="form-group">
							<label>Fabricante</label> <input type="text" class="form-control" name="fabricante" value="" id="" required>
						</div>
						<div class="form-group">
							<label>Problema</label>
							<textarea class="form-control" rows="5" name="descricao"></textarea>
						</div>
						<div class="form-group">
							<label>Previsão de Entrega</label> 
							<input type="text" class="form-control" name="previsao" value="" id="datepicker" required>
						</div>
						<div class="form-group">
							<label>Preço</label>
							<input type="text" class="form-control" data-symbol="R$ " data-thousands="." data-decimal="," name="valor" id="valor" value="" required>
						</div>
						<div class="form-group">
							<label>Estado</label> 
							<select class="form-control"  name="estado_id">
										<c:forEach items="${listaEstados}" var="item"  varStatus="cont">      
	        	                            <option value="${item.id}">${item.nome}</option>  
    	    							 </c:forEach>
							</select>
						</div>
						<br>
						<button type="submit" value="" class="btn btn-primary" >
						Cadastrar
						</button>
						<button type="submit" value="" class="btn btn-default" >
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