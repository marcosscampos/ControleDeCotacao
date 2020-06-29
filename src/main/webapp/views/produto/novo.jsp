<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css"/>
	<link rel="stylesheet" type="text/css"
	      href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
	<title>Sistema de Cotação | Novo Produto</title>
	
	<style>
		section {
			margin-bottom: 20px;
			margin-top: 20px;
		}
		
		main {
			margin-bottom: 20px;
		}
	</style>
</head>
<body class="container-fluid">
<%@include file="/common/header_produtos.jsp" %>
<section>
	<div class="list-group">
		<h4 class="text-center">Novo Produto</h4>
		<a href="<c:url value="/produtos"/> " class="btn btn-light">Voltar</a>
	</div>
</section>
<main>
	<form:form action="/produtos/novo-produto/criado" method="post" modelAttribute="novoProduto">
		<div class="form-group">
			<form:label path="nome">Produto: </form:label>
			<form:input path="nome"  cssClass="form-control"/>
			<form:errors path="nome"/>
		</div>
		<div class="form-group">
			<form:label path="fornecedor">Fornecedor: </form:label>
			<form:input path="fornecedor"  cssClass="form-control"/>
			<form:errors path="fornecedor"/>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-light">Cadastrar</button>
		</div>
	</form:form>
</main>
<%@include file="/common/footer.jsp" %>
</body>
</html>
