<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">

<title>Good Hands - App de Doações</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">
		<h3>Lista de Doadores</h3>

		<form action="/doador" method="get">
			<c:if test="${not empty mensagem}">
				<div class="alert alert-success">
					<strong>Sucesso!</strong> ${mensagem}
				</div>
			</c:if>
			<button class="btn btn-primary" type="submit">Novo</button>
		</form>

		<c:if test="${empty doadores}">
			<h5>Não existem doadores cadastrados!</h5>
		</c:if>
		
		<c:if test="${not empty doadores}">

			<h5>Quantidade de doadores cadastrados: ${doadores.size()}!</h5>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>CPF</th>
						<th>Usuário</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="g" items="${doadores}">
						<tr>
							<td>${g.id}</td>
							<td>${g.nome}</td>
							<td>${g.email}</td>
							<td>${g.cpf}</td>
							<td>${g.usuario.nome}</td>														
							<td><a href="/doador/${g.id}/excluir"><span
						class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

</body>
</html>