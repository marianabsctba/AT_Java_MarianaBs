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

			<h3>Transações cadastradas</h3>

		<form action="/transacao" method="get">
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Sucesso!</strong> ${mensagem}
			</div>
		</c:if>
		<button class="btn btn-primary" type="submit">Novo</button>
		</form>
		
		<c:if test="${empty transacoes}">
			<h4>Nenhuma transação foi encontrada :(</h4>
		</c:if>


		<c:if test="${not empty transacoes}">
			<h4>Número de transações cadastradas: ${transacoes.size()}</h4>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Descricao</th>
						<th>Frete</th>
						<th>Data</th>
						<th>Doador</th>
						<th>Produtos</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="t" items="${transacoes}">
						<tr>
							<td>${t.id}</td>
							<td>${t.descricao}</td>
							<td>${t.frete}</td>
							<td>${t.data}</td>
							<td>${t.doador.nome}</td>
							<td>${p.produtos.size()}</td>
							<td><a href="/transacao/${t.id}/excluir"><span
						class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

</body>
</html>