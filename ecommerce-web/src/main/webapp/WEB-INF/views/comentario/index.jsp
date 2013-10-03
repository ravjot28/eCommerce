<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>TABLA DE COMENTARIOS:</h1>
		<div>
		<c:forEach items="${comentarios}" var="comentario" varStatus="i">
		<c:if test="${account.resolver(comentario.aceptado) == 1}">
			<table class="table table-hover">
				
				<tbody>
						
						<tr>
							<td>${comentario.id}</td>
							<td>${comentario.account.email}</td>
							<td>${comentario.texto}</td>
							<td>${comentario.aceptado}</td>
							
						<td>
							<c:if test="${account.getPermiso() == 1}">
							<form action="block" method="get" >
								<input type="hidden" name="flag" value="${flag}">
								<input type="hidden" name="idComentable" value="${idComentable}">
								<input type="hidden" name="id" value="${comentario.id}">
								<input type="submit" value="block" >
							</form>
							</c:if>
						</td>
							
						<td>							
							<c:if test="${account.getEqualMail(comentario.account.email) == 1}">
								<form action="remove" method="get" >
									<input type="hidden" name="flag" value="${flag}">
									<input type="hidden" name="idComentable" value="${idComentable}">
									<input type="hidden" name="id" value="${comentario.id}">
									<input type="submit" value="remove" >
								</form>
							</c:if>
						</td>
						</tr>
						
				</tbody>
				
			</table>
			</c:if>
			</c:forEach>
		</div>
		<form action="add" method="post">
			<input type="hidden" name="flag" value="${flag}">
			<input type="hidden" name="idComentable" value="${idComentable}">
			<input type="text" name="texto" >
			<input type="submit" value="subir" >
		</form>
</body>
</html>