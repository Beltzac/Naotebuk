<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="usuario" scope="session" class="bean.LoginBean"/>
<c:if test="${!loginBean.autenticado}">
	<c:redirect url="Controladora?action=loginPage"/>
</c:if>

<!-- Header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-toggle"></span>
			</button>
			<a class="navbar-brand" href="#">Nãotebuk</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Controladora?action=logout"><i
						class="glyphicon glyphicon-lock"></i> Sair</a></li>
			</ul>
		</div>
	</div>
	<!-- /container -->
</div>
<!-- /Header -->