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
		<form action="movel/incluir" method="post">
			<h3>Cadastro de Moveis</h3>
			
			<c:import url="/WEB-INF/jsp/produto/cadastro.jsp" />

			<div class="form-group">
				<label>Marca:</label> <input type="text" class="form-control" name="marca" 
				value="Moveleiro">
				<label>Tamanho:</label> <input type="text" class="form-control" name="tamanho" 
				value="39">
			</div>

					

			<div class="form-group">
				<label>É usado:</label> <select name="usado"
					class="form-control">
					<option value="false" selected>SIM</option>
					<option value="true">NÂO</option>
				</select>
			</div>

			<button class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>

</body>
</html>