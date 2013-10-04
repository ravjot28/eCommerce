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
<script
	src="/ecommerce-web/src/main/webapp/resources/js/jquery-2.0.3.js"></script>
<body>
	<h1 class="text-danger">TABLA DE COMENTARIOS:</h1>
	<div>
		<!-- Abre el ForEach que recorre los Comentarios -->
		<c:forEach items="${comentarios}" var="comentario" varStatus="i">
			<c:if test="${account.resolver(comentario.aceptado) == 1}">
				<!-- Encierra los Comentarios en Paneles -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<!-- Se encarga de los Colapsos de los Comentarios -->
							<button type="button" class="btn btn-block btn-default"
								data-toggle="collapse" data-target="#${comentario.id}">Mostrar
								Comentario</button>
						</h4>
					</div>
					<div class="panel-body">
						<div id="${comentario.id}" class="collapse in">

							<blockquote class="">
								<p class="text-primary">${comentario.texto}</p>
								<small class="pull-right">Comentario mandado por: <cite
									title="UserName">${comentario.account.email}</cite></small>
							</blockquote>
							<br>
							<div align="center">
							<!-- Estos son los dos IF de los botones de BLOCK -->
							<c:if test="${account.getPermiso() == 1}">
								<form action="block" method="get">
									<input type="hidden" name="flag" value="${flag}"> <input
										type="hidden" name="idComentable" value="${idComentable}">
									<input type="hidden" name="id" value="${comentario.id}">
									<input type="submit" class="btn btn-danger" value="Blockear">
								</form>
							</c:if>
							<c:if test="${account.getPermiso() == 0}">
								<a href="#" data-toggle="tooltip"
									title="No tienes Permisos para Blockearlo"> <input
									type="submit" class="btn btn-default" value="Blockear">
								</a>
							</c:if>
							<br>
							<!-- Estos son los dos IF de los botones de ELIMINAR -->
							<c:if
								test="${account.getEqualMail(comentario.account.email) == 1}">
								<form action="remove" method="get">
									<input type="hidden" name="flag" value="${flag}"> <input
										type="hidden" name="idComentable" value="${idComentable}">
									<input type="hidden" name="id" value="${comentario.id}">
									<input type="submit" class="btn btn-danger" value="Remover">
								</form>
							</c:if>
							<c:if
								test="${account.getEqualMail(comentario.account.email) == 0}">
								<a href="#" data-toggle="tooltip"
									title="No tienes Permisos para Eliminarlo"> <input
									type="submit" class="btn btn-default" value="Remover">
								</a>
							</c:if>
							</div>

						</div>
					</div>
				</div>

			</c:if>
		</c:forEach>

	</div>
	<div>
		<h3>Mandar un Comentario</h3>
		<form action="add" method="post">
			<textarea class="form-control" rows="3" name="texto">Escribe aqui tu Comentario</textarea>
			<input type="hidden" name="flag" value="${flag}"> <input
				type="hidden" name="idComentable" value="${idComentable}"> <input
				type="submit" class="btn btn-success btn-block" value="subir">
		</form>
	</div>
</body>
</html>