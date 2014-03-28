<jsp:useBean id="usuario" scope="session" class="bean.LoginBean"/>

<% 
	/* Este é um comentário */
	if(!usuario.isAutenticado()) response.sendRedirect("login.jsp");
%>

<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="utf-8">
    <title>Nãotebuk</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
  </head>
  
  <body>
	<!-- Header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-toggle"></span>
      </button>
      <a class="navbar-brand" href="#">Nãotebuk</a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="login_manager.jsp?logout=true"><i class="glyphicon glyphicon-lock"></i> Sair</a></li>
      </ul>
    </div>
  </div><!-- /container -->
</div>
<!-- /Header -->

<!-- Main -->
<div class="container">
<div class="row">
	<div class="col-md-3">
      <!-- Left column -->
      <strong><i class="glyphicon glyphicon-wrench"></i> Painel</strong>
      <hr>
      <ul class="list-unstyled">
        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">
          <h5>Usuários <i class="glyphicon glyphicon-chevron-down"></i></h5>
          </a>
            <ul class="list-unstyled collapse in" id="userMenu">
                <li><a href="#"><i class="glyphicon glyphicon-user"></i> Cadastro</a></li>
				<li><a href="#"><i class="glyphicon glyphicon-pencil"></i> Editar</a></li>
				<li><a href="#"><i class="glyphicon glyphicon-search"></i> Pesquisar</a></li>
            </ul>
        </li>
        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu2">
          <h5>Consertos <i class="glyphicon glyphicon-chevron-down"></i></h5>
          </a>
            <ul class="list-unstyled collapse" id="menu2">
                <li><a href="#"><i class="glyphicon glyphicon-arrow-right"></i> Novo Pedido</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-arrow-right"></i> Cadastro</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-arrow-right"></i> Em aberto</a></li>
				<li><a href="#"><i class="glyphicon glyphicon-arrow-right"></i> Atrasados</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-arrow-right"></i> Prontos</a></li>            
				<li><a href="#"><i class="glyphicon glyphicon-arrow-right"></i> Todos</a></li>	
				<li><a href="#"><i class="glyphicon glyphicon-arrow-right"></i> Pagamento</a></li>
            </ul>
        </li>
      </ul>   
      <hr>
  	</div><!-- /col-3 -->
    <div class="col-md-9">
        <!-- Página aqui -->	
      <!-- column 2 -->	
      <strong><i class="glyphicon glyphicon-dashboard"></i> Página X</strong>
		<hr>
			<div class="row">
  
     
			
			
			</div>
      


	</div><!--/col-span-9-->
	</div>
</div>
<!-- /Main -->
  </body>
	<footer>	  <!-- /.footer -->
		<hr>
		<p class="text-center">Nãotebuk. Todos os direitos reservados 2014</p>
	</footer>
  <!-- /.footer -->
</html>