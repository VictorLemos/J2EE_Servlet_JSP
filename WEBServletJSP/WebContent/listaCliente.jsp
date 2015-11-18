<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de Clientes</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="container">
	<c:if test="${not empty msg }">
		<h4 class="alert alert-success">
			<c:out value="${msg }"/>
		</h4>
	</c:if>
	<h2>Lista de Clientes</h2>
	<table class="table">
		<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>Sexo</th>
			<th>E-mail</th>	
			<th>Telefone</th>			
			<th></th>
		</tr>
		<c:forEach var="c" items="${customers }">
			<tr>
				<td><c:out value="${c.nome }"/> </td>
				<td><c:out value="${c.cpf}"/> </td>
				<td><c:out value="${c.sexo }"/> </td>
				<td><c:out value="${c.email }"/> </td>
				<td><c:out value="${c.telefone}"/> </td>
				<td>
					<c:url value="CustomerServlet" var="link">
						<c:param name="acao" value="exibir"/>
						<c:param name="id" value="${c.id }"/>
					</c:url>
					<a href="${link }" class="btn btn-info">Alterar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>


</body>
</html>