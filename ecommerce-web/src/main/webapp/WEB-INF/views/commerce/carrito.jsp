<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div align = "center">
	<h1>Carrito de Compras</h1>
	<h3>Usuario: ${email}</h3>
	<br />
	<br />
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id de Producto</th>
				<th>Producto</th>
				<th>Cantidad</th>
				<th>Precio Unitario</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ carrito}" var="productoComprable" varStatus="i">
				<tr>				
					<td>${productoComprable.producto.id}</td>
					<!--<td>${productoCarrito.productosComprables.id }</td>-->
					<td>
						<form action="detalle" method="post">
							<input type="submit" class="btn btn-link" name="nombreProducto" value="${productoComprable.producto.nombre}"/>
							<input type="hidden" name="id" value="${productoComprable.producto.id }"/>
						</form>
					</td>
					<td>
						<form action="guardar" method="get">
							<input type="text" value="${productoComprable.cantidad}" name="cantidad" id="cantidad"/>
							<input type="hidden" name="id" value="${productoComprable.id }"/>
							<input type="submit" class="btn btn-link btn-sm" value="Guardar" name="guardar"/>
						</form>
					</td>					
					<td><fmt:formatNumber type="currency" value="${productoComprable.producto.precio}" currencyCode="ARS"/></td>
					<td>
						<form action="borrar" method="get">
							<input type="hidden" name="id" value="${productoComprable.id }"/>
							<input type="submit" class="btn btn-danger btn-xs" name="borrar" id="borrar" value="Borrar"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="crearChanguito" method="post">
		<input type="hidden" name="carrito" value="${carrito }"/>
		<input type="submit" name="confirmar"  value="Confirmar Compra"/>
	</form>
</div>