<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2 class="remarco text-muted">Agregar Cuenta Administrador</h2>
	<div>
		<form action="createU" method="post">
			<label for="email" class="text-muted">Email</label> 
			<input id="email" type="text" name="email" />
			 
			<label for="password" class="text-muted">Password</label>
			<input id="password" type="text" name="password" />
			
			<input type="hidden" value="ROLE_ADMIN" name="role" /> 
			
			<input type="submit" class="btn btn-success" />
		</form>
	</div>
	
	<h2 class="remarco text-muted">Lista de usuarios</h2>
	<div>
		<table class="table table-striped">
			<thead>
				<tr class="htabla">
					<th>Email</th>
					<th>ROL</th>
					<th>Aplicaciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach  items="${accounts}"  var="account">
					<tr>
						<td>${account.email}</td>
						<td>${account.role}</td>
						<td>
							<form action="delete" method="post">
								<input type="hidden" value="${account.id}" name="id" /> 
								<input type="hidden" value="account" name="tipo" /> 
								<input type="submit" value=Eliminar class="btn btn-danger btn-xs" />
							</form>
							<form action="editarU" method="GET">
								<input type="hidden" name="id" value="${account.id}" />
								<button class="btn btn-warning btn-xs">Editar</button>
							</form>
							<form action="//localhost:8080/ecommerce-web/comentario/index" method="GET">
								<input type="hidden" name="id" value="${account.id}" />
								<input type="hidden" name="flag" value="false"/>
								<button class="btn btn-default btn-xs" >Comentarios</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</div>



	<a href="mainAdmin"><button class="btn btn-success">ATRAS</button></a>

</body>
</html>