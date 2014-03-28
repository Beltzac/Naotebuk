<jsp:useBean id="usuario" scope="session" class="bean.LoginBean"/>

<% 	
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
      <strong><i class="glyphicon glyphicon-dashboard"></i> Página X</strong>
		<hr>
			<div class="row">
  
     
			
			
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