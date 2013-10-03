<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<h1>Productos de ${fab.nombre}</h1>

<table class="table table-condensed text-muted">
			<thead class="remarco">
				<tr class="htabla">
					<th>Nombre</th>
					<th>Precio</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productos}" var="producto">
					<tr>
						<td class="text-muted">${producto.nombre}</td>
						<td class="text-muted">${producto.precio}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="cargarFabricante"><button class="btn btn-info btn-xl"> Volver </button></a>
