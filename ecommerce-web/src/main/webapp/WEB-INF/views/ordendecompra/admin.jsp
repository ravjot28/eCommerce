<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div align="center">
	<h1>Admin</h1>
</div>
<br />
<div>
	<table class="table table-bordered">
		<tr>
			<td>ID</td>
			<td>Usuario</td>
			<td>Producto</td>
			<td>Estado</td>
		</tr>
		<c:forEach items="${compras}" var="compra">
			<tr>
				<td></td>
				<td>${compra.usuario}</td>
				<td>${compra.productos}</td>
				<td>
					<form action="" method="POST">
						<input type="hidden" value="${compra.usuario}" name="usuario"/>
						<input type="hidden" value="${compra.producto}" name="producto"/>
						<select name="estadoCompra">
							<option values="aceptado">Aceptado</option>
							<option values="rechazado">Rechazado</option>
						</select>
						<button type="submit" class="btn btn-primary">Aceptar</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>