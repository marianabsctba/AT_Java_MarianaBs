<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet" />
<!-- Custom styles for this template-->


	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	      <a href="#" class="logo d-flex align-items-center">
        <img src="/img/logo.png" alt="">
        <span class="d-none d-lg-block">Good Hands</span>
      </a>
       <i class="bi bi-list toggle-sidebar-btn"></i>
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"></a>
			</div>
			<ul class="nav navbar-nav">
				<li class="nav-link active"><a href="/home">Home</a></li>

				<c:if test="${not empty user}">
					<li><a class="nav-link" href="/usuario/lista">Usuario</a></li>
					<li><a class="nav-link" href="/alimento/lista">Alimento</a></li>
					<li><a class="nav-link" href="/vestuario/lista">Vestuario</a></li>
					<li><a class="nav-link" href="/movel/lista">Movel</a></li>
					<li><a class="nav-link" href="/doador/lista">Doador</a></li>
					<li><a class="nav-link" href="/produto/lista">Produto</a></li>
					<li><a class="nav-link" href="/transacao/lista">Transação</a></li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav">
				<c:if test="${empty user}">
					<li><a href="/usuario"><span
							class="bi bi-pencil-fill"></span> Sign Up /</a></li>
					<li><a href="/login"><span
							class="bi bi-person"></span> Login</a></li>
				</c:if>
				<c:if test="${not empty user}">
					<li><a href="/logout"><span
							class="bi bi-dash-circle"></span> Logout, ${user.nome}</a></li>
				</c:if>
			</ul>
		</div>
	</nav>

</body>
</html>