<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>Good Hands - Cadastro</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet" />

</head>

<body class="bg-gradient-primary">

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">

		<form action="/cep" class="form-inline" method="post">

			<label>Cep:</label> <input type="text" name="cep" value="20010020"
				class="form-control">

			<button type="submit" class="btn btn-primary">Buscar</button>
		</form>

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-10">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Crie uma conta!</h1>

								<form action="/usuario/incluir" method="post" class="user">
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<input type="text" class="form-control form-control-user"
												name="nome" placeholder="Nome" value="Mariana Buhrer">
										</div>
										<div class="col-sm-6">
											<input type="number" class="form-control form-control-user"
												name="idade" placeholder="Idade" value="33">
										</div>
									</div>
									<div class="form-group">
										<input type="email" class="form-control form-control-user"
											name="email" placeholder="Email" value="msukevicz@gmail.com">
									</div>
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<input type="password" class="form-control form-control-user"
												name="senha" placeholder="Senha" value="msukevicz@gmail.com">
										</div>
									</div>
									<div class="form-group">
										<label>Tipo:</label>
										<div class="form-check">
											<label class="form-check-label"> <input type="radio"
												name="tipo" value="PF" class="form-check-input">
												Pessoa física
											</label>
										</div>
										<div class="form-check">
											<label class="form-check-label"> <input type="radio"
												name="tipo" value="PJ" checked class="form-check-input">Pessoa
												jurídica
											</label>
										</div>
									</div>
									<button type="submit"
										class="btn btn-primary btn-user btn-block">Registrar
										conta</button>
								</form>
								<hr>
								<div class="text-center">
									<a class="small" href="/login">Já tem conta? Faça login!</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
	<!-- Footer-->
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<c:import url="/WEB-INF/jsp/footer.jsp" />