<jsp:useBean id="usuario" scope="session" class="bean.LoginBean"/>

<% 
	//teste
	if(usuario.isAutenticado()) response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html>

 <head>
    <meta charset="UTF-8">
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
  </div><!-- /container -->
</div>
<!-- /Header -->
<div class="container">
<div class="row">
	<div class="col-md-5">
      
  	</div><!-- /col-3 -->
    <div class="col-md-5">
        <!-- Página aqui -->	
      <!-- column 2 -->	
     

			<div class="row">
			<div class="col-md-7">
				<h2>Login</h2>
			<br>
            <form id="login" method="post" action="login_manager.jsp" role="form">
                <label>E-mail:</label>
                <input type="text" name="email"  value="" class="form-control" />
				<br>
                <label>Senha:</label>
                <input type="password" name="senha" value="" class="form-control" />
				<br>
                <center><button type="submit" value="Login" class="btn btn-primary" />Login</button></center>


            </form>
			</div>
     
			
			
			</div>
      

      

	</div><!--/col-span-9-->
	</div>
</div>

</body>

  <!-- /.footer -->
</html>