<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Good Hands</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<head>
<meta charset="utf-8" />
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet" />
<!-- Refresh (page) -->
<meta http-equiv="refresh" content="10">
</head>

<body class="bg-gradient-primary">

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">

		<c:if test="${not empty mensagem}">
			<div class="alert alert-danger">
				<strong>Alerta!</strong> ${mensagem}
			</div>
		</c:if>

		<!-- Outer Row -->
		<body id="page-top">

			<div class="row justify-content-center">

				<div class="col-xl-10 col-lg-12 col-md-9">

					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<!-- Nested Row within Card Body -->


							<div class="row">
								<div class="col-lg-6 d-none d-lg-block bg-login-image" src="/img/goodhands.jpg"></div>
								<div class="col-lg-6">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">Bem-vindo(a) a Good Hands!</h1>
										</div>
										
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">Doe e contribua!</h1>
										</div>

										<form action="/login" method="post" class="user">
											<div class="form-group">
												<label>E-mail:</label> <input type="email"
													class="form-control" placeholder="Digite seu e-mail"
													name="email" value="msukevicz@gmail.com">
											</div>
											<div class="form-group">
												<label>Senha:</label> <input type="password"
													class="form-control" placeholder="Digite sua senha"
													name="senha" value="msukevicz@gmail.com">
											</div>
											<button type="submit"
												class="btn btn-primary btn-user btn-block">Login</button>
										</form>
										<hr>
										<div class="text-center">
											<a class="small" href="/usuario">Ainda não tem uma conta?
												Registre-se aqui!</a>
										</div>
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
</body>
</html>