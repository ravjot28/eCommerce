<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div>
	<h1>Carrito de Compras</h1>
	<br />
	<br />
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Producto</th>
				<th>Cantidad</th>
				<th>Precio Unitario</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="carrito" var="producto" varStatus="i">
				<tr>
					<td>${producto.producto }</td>
					<td><input type="text" value="${producto.cantidad }" name="cantidad" id="cantidad"/></td>
					<td>${producto.precioPagado }</td>
					<td>
						<form action="borrar" method="get">
							<input type="hidden" name="idProducto" value="${producto.producto }"/>
							<input type="submit" name="borrar" id="borrar" value="Borrar"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>