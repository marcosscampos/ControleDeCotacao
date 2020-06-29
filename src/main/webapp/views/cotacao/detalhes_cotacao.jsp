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
	<title>Sistema de Cotação | Nova Cotação</title>
	
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
<%@include file="/common/header.jsp" %>
<section>
	<div class="list-group">
		<h4 class="text-center">Detalhes da Cotação do Cliente: ${editar.nomeCliente}</h4>
		<a href="<c:url value="/"/> " class="btn btn-light">Voltar</a>
	</div>
</section>
<main>
	<div>
		<h5>Nome Produto: ${editar.idProduto.nome}</h5>
		<p data-currency>Valor Cotado: R$: ${editar.preco}</p>
		<p>Data da Cotação: </p><span data-moment>${editar.data}</span>
	</div>
</main>
<%@include file="/common/footer.jsp" %>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/locale/pt-br.min.js"></script>

<script>
    const dataMoment = document.querySelectorAll('[data-moment]')

    dataMoment.forEach(data => {
        moment.locale('br')
        data.textContent = moment(data.textContent).fromNow()
    })
</script>
</html>