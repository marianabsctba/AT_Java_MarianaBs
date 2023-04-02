<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Good Hands - App de Doa��es</title>
<meta http-equiv="refresh" content="10">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">
		<form action="vestuario/incluir" method="post">
			<h3>Cadastro de Vestu�rio</h3>

			<div class="form-group">
				<label>Nome: </label> <input type="text" class="form-control"
					name="nome" value="Blusa"> 
				<label>Marca:</label> <input type="text" class="form-control" name="marca" 
				value="Gucci">
				<label>Tamanho:</label> <input type="text" class="form-control" name="tamanho" 
				value="39">
				<label>Valor:</label> <input type="text" class="form-control" name="valor" 
				value="289999.00">
			</div>

					

			<div class="form-group">
				<label>� usado:</label> <select name="usado"
					class="form-control">
					<option value="false" selected>SIM</option>
					<option value="true">N�O</option>
				</select>
			</div>
			
			<div class="form-group">
				<label>� roupa:</label> <select name="roupa"
					class="form-control">
					<option value="true" selected>SIM</option>
					<option value="false">N�O</option>
				</select>
			</div>

			<button class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>

</body>
</html>