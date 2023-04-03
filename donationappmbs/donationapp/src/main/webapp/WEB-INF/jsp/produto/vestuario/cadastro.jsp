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
<meta http-equiv="refresh" content="10">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">
		<form action="vestuario/incluir" method="post">
			<h3>Cadastro de Vestuário</h3>

			<c:import url="/WEB-INF/jsp/produto/cadastro.jsp" />

			<div class="form-group">
				<label>Marca:</label> <input type="text" class="form-control"
					name="marca" value="Gucci"> <label>Tamanho:</label> <input
					type="text" class="form-control" name="tamanho" value="39">
			</div>



			<div class="form-group">
				<label>É usado:</label> <select name="usado" class="form-control">
					<option value="false" selected>SIM</option>
					<option value="true">NÂO</option>
				</select>
			</div>

			<div class="form-group">
				<label>É roupa:</label> <select name="roupa" class="form-control">
					<option value="true" selected>SIM</option>
					<option value="false">NÂO</option>
				</select>
			</div>

			<button class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>

</body>
</html>