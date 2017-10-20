<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Cadastro de produtos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/cerulean/bootstrap.min.css" />
	<style>
		.error {
			color: red;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<div class="container">

		<!--<spring:hasBindErrors name="product">

			<c:forEach var="error" items="${errors.allErrors}">
				<div class="alert alert-danger">${error.defaultMessage}</div>
			</c:forEach>

		</spring:hasBindErrors>-->

		<form:form method="post" action="/biblioteca/produtos" commandName="product">
			<div class="form-group">
				<label for="title">Titulo</label> 
				<input type="text" name="title"	id="title" class="form-control" />
				<form:errors path="title" cssClass="error"/>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="pages">Número de paginas</label> 
						<input type="text"	name="pages" id="pages" class="form-control" />
						<form:errors path="pages" cssClass="error"/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="releaseDate">Data de lançamento</label> 
						<input type="date"	name="releaseDate" id="releaseDate" class="form-control" />
						<form:errors path="releaseDate" cssClass="error"/>
					</div>
				</div>
			</div>
			
			<div class="row">
				<c:forEach items="${types}" var="bookType" varStatus="status">
					<div class="col-sm-2">
						<div class="form-group">
							<label for="price_${bookType}">${bookType}</label> 
							<input class="form-control" type="text"	name="prices[${status.index}].value" id="price_${bookType}" /> 
							<input class="form-control" type="hidden" name="prices[${status.index}].bookType" value="${bookType}" />
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="form-group">
				<label for="description">Descrição</label>
				<textarea rows="10" cols="20" name="description" id="description"	class="form-control"></textarea>
				<form:errors path="description" cssClass="error"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Cadastrar" class="btn btn-primary">
			</div>
		</form:form>
	</div>
</body>
</html>