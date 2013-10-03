<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<label for="email" class="text-muted">Email</label> <input id="email"
				type="text" name="email" /> <label for="password"
				class="text-muted">Password</label> <input id="password" type="text"
				name="password" /> <input type="hidden" value="ROLE_ADMIN"
				name="role" /> <input type="submit" class="btn btn-success" />
		</form>
	</div>
	<div>
		<table class="table table-condensed text-muted">
			<thead class="remarco">
				<tr class="htabla">
					<th>ID</th>
					<th>Nombre</th>
					<th>ROL</th>
					<th>Aplicaciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accounts}" var="user">
					<tr>
						<td class="text-muted">${user.id}</td>
						<td class="text-muted">${user.email}</td>
						<td class="text-muted">${user.role}</td>
						<td>
							<div class="btn-group">
								<button type="button" class="btn btn-success dropdown-toggle"
									data-toggle="dropdown">
									Action <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li>
										<form action="delete" method="post">
											<input type="hidden" value="${user.id}" name="id" /> <input
												type="hidden" value="account" name="tipo" /> <input
												type="submit" value=Eliminar class="btn btn-danger btn-xs" />
										</form>
									</li>
									<li><a href="modificar?id=${user.id}"
										class="btn btn-warning btn-xs">Modificar</a></li>
								</ul>
							</div>
						</td>
					</tr>

				</c:forEach>
			</tbody>

		</table>

	</div>



	<a href="mainAdmin"><button class="btn btn-success">ATRAS</button></a>

</body>
</html>