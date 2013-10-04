<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>


<center>
	<h1>Detalle de Producto</h1>
</center>
<p></p>
<div align="center">
	<table class="table table-striped">
		<thead>

			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Fabricante</th>
				<th>Precio</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${producto.id}</td>
					<td>${producto.nombre}</td>
					<td>${producto.fabricante.getNombre()}</td>
					<td><fmt:formatNumber type="currency"
							value="${producto.precio}" currencyCode="ARS" /></td>
				</tr>
				<form action="volverAlCarrito" method="post">
					<input type="submit" name="volverAlCarrito" value="Volver al Carrito"/>
				</form>
			</tbody>
	</table>

</div>