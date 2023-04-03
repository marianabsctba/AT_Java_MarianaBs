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

			<h3>Alimentos cadastrados</h3>

		<form action="/alimento" method="get">
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Sucesso!</strong> ${mensagem}
			</div>
		</c:if>
		<button class="btn btn-primary" type="submit">Novo</button>
		</form>
		
		<c:if test="${empty alimentos}">
			<h4>Nenhum alimento foi encontrado :(</h4>
		</c:if>


		<c:if test="${not empty alimentos}">
			<h4>Número de alimentos cadastrados: ${alimentos.size()}</h4>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Marca</th>
						<th>Meses</th>
						<th>Perecivel</th>
						<th>Valor</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="a" items="${alimentos}">
						<tr>
							<td>${a.id}</td>
							<td>${a.nome}</td>
							<td>${a.marca}</td>
							<td>${a.meses}</td>
							<td>${a.perecivel}</td>
							<td>${a.valor}</td>
							<td><a href="/alimento/${a.id}/excluir"><span
						class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

</body>
</html>