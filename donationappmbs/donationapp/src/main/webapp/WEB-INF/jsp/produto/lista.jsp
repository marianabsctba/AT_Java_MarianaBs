<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Good Hands - App de Doações</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />
	
	<div class="container">

			<h3>Lista de produtos</h3>

		<form action="/alimento" method="get">
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Sucesso!</strong> ${mensagem}
			</div>
		</c:if>
		</form>
		
		<c:if test="${empty produtos}">
			<h4>Nenhum produto foi cadastrado :(</h4>
		</c:if>


		<c:if test="${not empty produtos}">
			<h4>Número de produtos cadastrados: ${produtos.size()}</h4>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Valor</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="p" items="${produtos}">
						<tr>
							<td>${p.nome}</td>
							<td>${p.valor}</td>
							<td><a href="/alimento/${p.id}/excluir"><span
						class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

</body>
</html>