<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div align="center">
	<h1>User</h1>
</div>
<br />
<div>
	<table>
		<tr>
			<td>ID</td>
			<td>Usuario</td>
			<td>Producto</td>
			<td>Estado</td>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuarios.id}</td>
				<td>${usuarios.usuario}</td>
				<td>${usuarios.producto}</td>
				<td>${usuarios.estadoCompra}</td>
			</tr>
		</c:forEach>
	</table>
</div>