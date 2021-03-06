 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Left column -->
<div class="col-md-3">   
      <strong><i class="glyphicon glyphicon-wrench"></i> Painel</strong>
      <hr>
      <ul class="list-unstyled">
        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">
          <h5>Usuários <i class="glyphicon glyphicon-chevron-down"></i></h5>
          </a>
            <ul class="list-unstyled collapse in" id="userMenu">
                        
             <li><a href="Controladora?action=pesquisaUsuario"><i class="glyphicon glyphicon-search"></i> Pesquisar</a></li>
            
			<c:if test="${loginBean.gerente}">
               <li><a href="Controladora?action=cadastroUsuario"><i class="glyphicon glyphicon-user"></i> Cadastro</a></li>                            
			</c:if>
            </ul>
        </li>
         <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#cliMenu">
          <h5>Clientes <i class="glyphicon glyphicon-chevron-down"></i></h5>
          </a>
            <ul class="list-unstyled collapse in" id="cliMenu">
                        
             <li><a href="Controladora?action=pesquisaCliente"><i class="glyphicon glyphicon-search"></i> Pesquisar</a></li>
              <li><a href="Controladora?action=cadastroCliente"><i class="glyphicon glyphicon-arrow-right"></i> Cadastro</a></li>                            
		
            </ul>
        </li>
        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu2">
          <h5>Consertos <i class="glyphicon glyphicon-chevron-down"></i></h5>
          </a>
            <ul class="list-unstyled collapse in" id="menu2">
                <li><a href="Controladora?action=cadastroPedido"><i class="glyphicon glyphicon-arrow-right"></i> Novo Pedido</a></li>                
                <li><a href="Controladora?action=emAberto"><i class="glyphicon glyphicon-arrow-right"></i> Em aberto</a></li>
				<li><a href="Controladora?action=atrasados"><i class="glyphicon glyphicon-arrow-right"></i> Atrasados</a></li>
                <li><a href="Controladora?action=prontos"><i class="glyphicon glyphicon-arrow-right"></i> Prontos</a></li>
                <li><a href="Controladora?action=pagos"><i class="glyphicon glyphicon-arrow-right"></i> Retirada (Pagos)</a></li>
                <li><a href="Controladora?action=finalizados"><i class="glyphicon glyphicon-arrow-right"></i> Finalizados</a></li>            
				<li><a href="Controladora?action=listarTodos"><i class="glyphicon glyphicon-arrow-right"></i> Todos</a></li>	
				<li><a href="Controladora?action=pesquisaPedido"><i class="glyphicon glyphicon-arrow-right"></i> Busca</a></li>
            </ul>
        </li>
        <a href="Controladora?action=relatorio">
          <h5>Relatórios <i class="glyphicon glyphicon-globe"></i></h5>
        </a>
      </ul>   
      <hr>
  	</div><!-- /col-3 -->