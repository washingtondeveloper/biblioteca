<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Listagem</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/cerulean/bootstrap.min.css" />
</head>
<body>

	<c:if test="${sucesso != null}">
		<div class="alert alert-success">${sucesso}</div>
	</c:if>

	<table class="table table-bordered">
		<tr>
			<th>Titulo</th>
			<th>Valores</th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.title}</td>
				<td><c:forEach items="${product.prices}" var="price">
						[${price.value}	-	${price.bookType}]
					</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>