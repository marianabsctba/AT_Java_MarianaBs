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

			<h3>Vestuarios cadastrados</h3>

		<form action="/vestuario" method="get">
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Sucesso!</strong> ${mensagem}
			</div>
		</c:if>
		<button class="btn btn-primary" type="submit">Novo</button>
		</form>
		
		<c:if test="${empty vestuarios}">
			<h4>Nenhum vestuário foi encontrado :(</h4>
		</c:if>


		<c:if test="${not empty vestuarios}">
			<h4>Número de vestuários cadastrados: ${vestuarios.size()}</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Marca</th>
						<th>Usado</th>
						<th>Tamanho</th>
						<th>Valor</th>
						<th>É Roupa</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="k" items="${vestuarios}">
						<tr>
							<td>${k.id}</td>
							<td>${k.nome}</td>
							<td>${k.marca}</td>
							<td>${k.usado}</td>
							<td>${k.tamanho}</td>
							<td>${k.valor}</td>
							<td>${k.roupa}</td>
							<td><a href="/vestuario/${k.id}/excluir"><span
						class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

</body>
</html>