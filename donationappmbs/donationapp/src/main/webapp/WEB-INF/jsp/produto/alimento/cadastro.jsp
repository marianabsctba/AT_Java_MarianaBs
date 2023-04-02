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
		<form action="alimento/incluir" method="post">
			<h3>Cadastro de Alimentos</h3>
			
			<c:import url="/WEB-INF/jsp/produto/cadastro.jsp" />

			<div class="form-group">
				<label>Marca:</label> <input type="text" class="form-control" name="marca" 
				value="Tio Joao">
				<label>Meses:</label> <input type="text" class="form-control" name="meses" 
				value="9">
			</div>

					

			<div class="form-group">
				<label>É perecivel:</label> <select name="perecivel"
					class="form-control">
					<option value="false" selected>NÃO</option>
					<option value="true">SIM</option>
				</select>
			</div>

			<button class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>

</body>
</html>