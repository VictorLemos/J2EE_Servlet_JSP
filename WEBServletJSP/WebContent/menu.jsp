<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar navbar-default">
	<div class="container">
		<a href="home.jsp" class="navbar-brand">Empresa XPTO</a>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Clientes <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="formularioCliente.jsp">Cadastrar Cliente</a></li>
					<li><a href="CustomerServlet?acao=listar">Clientes </a></li>
				</ul>
			</li>		
		</ul>
	</div>
</div>


