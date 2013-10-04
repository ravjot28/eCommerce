<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>


<center>
	<h1>Resultado de busqueda</h1>
</center>
<p></p>
<div>
	<table class="table table-striped">
		<thead>
			<tr>
			<th> </th>
			<th>Id</th>
			<th>Nombre</th>
			<th>Fabricante</th>
			<th>Precio</th>
			<th>Comentarios Productos</th>
			<th>Comentarios Fabricantes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="producto" varStatus="i">
				<tr>
					<td>${i.index+1}</td>
					<td>${producto.id}</td>
					<td>${producto.nombre}</td>
					<td>${producto.fabricante.getNombre()}</td>
					<td><fmt:formatNumber type="currency"
							value="${producto.precio}" currencyCode="ARS" /></td>
					<td>
											
					<form action="http://localhost:8080/ecommerce-web/comentario/index" method="get">
						<input type="hidden" name="id" value="${producto.id}"/>
						<input type="hidden" name="flag" value="true"/>
						<input class="button-small" type="submit" value="Comentar" />
					</form>
					</td>
					<td>
				<form action="//localhost:8080/ecommerce-web/comentario/index" method="get">
						<input type="hidden" name="id" value="${producto.fabricante.id}"/>
						<input type="hidden" name="flag" value="false"/>
						<input class="button-left" type="submit" value="Comentar" />
					</form>
					</td>
					<td>
						<form action="agregarAlCarrito" method="POST">
							<input type="hidden" value="${producto.id }" name="idProducto"/>
							<input type="submit" value="Agregar al Carrito" name="agregarCarrito"/>
						</form>
					</td>

				</tr>
			</c:forEach>
				
		</tbody>
	</table>
<p align=center> <a class="button-left" href="/ecommerce-web/buscar/busqueda"><b>Volver a Búsqueda</b></a></p>
</div>




