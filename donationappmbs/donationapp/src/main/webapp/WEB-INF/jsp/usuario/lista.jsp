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

			<h3>Usuarios cadastrados</h3>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Uhulll!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${empty usuarios}">
			<h4>Nenhum usuário foi encontrado :(</h4>
		</c:if>


		<c:if test="${not empty usuarios}">
			<h4>Número de usuários cadastrados: ${usuarios.size()}</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Senha</th>
						<th>E-mail</th>
						<th>Idade</th>
						<th>Tipo</th>
						<th>N. de Doadores</th>
						<th>N. de Produtos</th>
						<th>N. de Transações</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="u" items="${usuarios}">
						<tr>
							<td>${u.id}</td>
							<td>${u.nome}</td>
							<td>${u.senha}</td>
							<td>${u.email}</td>
							<td>${u.idade}</td>
							<td>${u.tipo}</td>
							<td>${u.doadores.size()}</td>
							<td>${u.produtos.size()}</td>
							<td>${u.transacoes.size()}</td>
							<td><a href="/usuario/${u.id}/excluir"><span
						class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>