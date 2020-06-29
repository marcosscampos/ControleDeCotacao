<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css"/>
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css"
	      href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<title>Sistema de Cotação | Cotação</title>
	
	<style>
		section {
			margin-bottom: 20px;
			margin-top: 20px;
		}
	</style>
</head>
<body class="container-fluid">
<%@include file="/common/header.jsp" %>
<section>
	<div class="list-group">
		<h4 class="text-center">Cotações</h4>
		<a href="<c:url value="/nova-cotacao"/> " class="btn btn-light">Nova Cotação</a>
	</div>
</section>
<main>
	<div>
		<div>
			<table class="table table-striped table-bordered" id="table">
				<thead>
				<tr>
					<th>Produto</th>
					<th>Valor</th>
					<th>Data</th>
					<th>Nome Cliente</th>
					<th>Ações</th>
				</tr>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${!empty cotacoes}">
						<c:forEach var="cotacao" items="${cotacoes}">
							<tr>
								<td>${cotacao.idProduto.nome}</td>
								<td data-currency>${cotacao.preco}</td>
								<td data-moment>${cotacao.data}</td>
								<td>${cotacao.nomeCliente}</td>
								<td class="text-center">
									<a href="/${cotacao.id}" title="Excluir">
									<i class="fa fa-times"></i>
									</a>
									<a href="/detalhes-cotacao/${cotacao.id}" title="Detalhes">
										<i class="fa fa-info-circle"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p>Nenhuma cotação adicionada</p>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</main>
<%@include file="/common/footer.jsp" %>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/locale/pt-br.min.js"></script>
<script>
    const dataMoment = document.querySelectorAll('[data-moment]')
    const dataCurrency = document.querySelectorAll('[data-currency]')

    dataMoment.forEach(data => {
        moment.locale('br')
        data.textContent = moment(data.textContent).fromNow()
    })
    dataCurrency.forEach(data => {
        let opts = { style: 'currency', currency: 'BRL' };
        data.textContent = new Intl.NumberFormat('pt-BR', opts).format(data.textContent);
    })
    
    $(document).ready(function () {
        $('#table').DataTable({
            responsive: true,
            processing: true,
	        language: {
                url: "https://cdn.datatables.net/plug-ins/1.10.21/i18n/Portuguese-Brasil.json"
	        },
            autoWidth: true
        });
    });
</script>
</html>
