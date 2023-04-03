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
		<form action="doador/incluir" method="post">
			<h3>Cadastro de Doadores</h3>

			<div class="form-group">
				<label>Nome: </label> <input type="text" class="form-control"
					name="nome" value="Mariana Buhrer"> 
				<label>CPF ou CNPJ:</label> <input type="number" class="form-control" name="cpf" 
				value="300006666">
				<label>Email:</label> <input type="email" class="form-control" name="email" 
				value="m@gmail.com">
			</div>

			<button class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>

</body>
</html>