<jsp:useBean id="usuario" scope="session" class="bean.LoginBean"/>
<jsp:setProperty property="*" name="usuario"/>
	
<%

if(request.getParameter("logout") != null){
	if(session!=null){
		System.out.println("Usuario deslogado:" + usuario.getEmail() );
		session.invalidate();		
		response.sendRedirect("login.jsp");
	}
}else{
	//buscar usuario

	if (usuario.autenticar()) {		
		System.out.println("Usuario logando:" + usuario.getEmail() );
		response.sendRedirect("listaPedidos.jsp");
	} else{
		usuario.setEmail(null);
		usuario.setSenha(null);
		response.sendRedirect("login.jsp");
}
	}
%>


