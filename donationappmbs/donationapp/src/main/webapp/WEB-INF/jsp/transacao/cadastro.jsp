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
		<form action="transacao/incluir" method="post">
			<h3>Cadastro de Transacoes</h3>
			
			<c:set var="botao" value=""/>

			<div class="form-group">
				<label>Descrição:</label> <input type="text" class="form-control" name="descricao" 
				value="Para higiene">
				<label>Data:</label> <input type="text" class="form-control" name="data" 
				value="22/11/2023">
			</div>

					

			<div class="form-group">
				<label>Frete:</label> <select name="entregaComFrete"
					class="form-control">
					<option value="false" selected>NÃO</option>
					<option value="true">SIM</option>
				</select>
			</div>
			
			
			<div class="form-group">
				<c:if test="${not empty doadores}">
					<label>Doador:</label>
					<select name="doador" class="form-control">
						<c:forEach var="g" items="${doadores}">
							<option value="${g.id}">${g.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty doadores}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem doadores cadastrados!</label>
				</c:if>
			</div>
			
			<div class="form-group">
				<c:if test="${not empty produtos}">
					<label>Produtos:</label>
				    <c:forEach var="p" items="${produtos}">
				    <div class="form-check">
				      <label class="form-check-label">
			        		<input type="checkbox" name="produtos" value="${p.id}" class="form-check-input"> ${p.nome}
				      </label>
				    </div>
				    </c:forEach>
				</c:if>
				<c:if test="${empty produtos}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem produtos cadastrados!</label>
				</c:if>
			</div>

			<button class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>

</body>
</html>