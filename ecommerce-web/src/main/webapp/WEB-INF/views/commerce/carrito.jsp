<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div>
	<h1>Carrito de Compras</h1>
	<h3>${usuario.mail}</h3>
	<br />
	<br />
	<table class="table table-striped">
		<thead>
			<tr>
				<th>idProducto</th>
				<th>Producto</th>
				<th>Cantidad</th>
				<th>Precio Unitario</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="carrito" var="producto" varStatus="i">
				<tr>
					
					<td>${producto.producto.id}</td>
					<td>
						<form action="verDetalle" method="post">
							<input type="submit" class="btn btn-link" name="nombreProducto" value="${producto.producto.nombre}"/>
							<input type="hidden" name="id" value="${producto.producto.id }"/>
						</form>
					</td>
					<td>
						<form action="verDetalle" method="get">
							<input type="text" value="${producto.cantidad}" name="cantidad" id="cantidad"/>
							<input type="hidden" name="id" value="${producto.producto.id }"/>
							<input type="submit" class="btn btn-link btn-sm" value="Guardar" name="guardar"/>
						</form>
					</td>					
					<td><fmt:formatNumber type="currency" value="${producto.producto.precio}" currencyCode="ARS"/></td>
					<td>
						<form action="borrar" method="get">
							<input type="hidden" name="id" value="${producto.producto.id }"/>
							<input type="hidden" name="cantidad" value="${producto.cantidad }"/>
							<input type="submit" class="btn btn-danger btn-xs" name="borrar" id="borrar" value="Borrar"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>