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

			<center><tr>
				<th> </th>
				<th>Id</th>
				<th>Nombre</th>
				<th>Fabricante</th>
				<th>Precio</th>
			</tr></center>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="producto" varStatus="i">
				<tr>
					<center><td>${i.index+1}</td>
					<td>${producto.id}</td>
					<td>${producto.nombre}</td>
					<td>${producto.fabricante.getNombre()}</td>
					<td><fmt:formatNumber type="currency"
							value="${producto.precio}" currencyCode="ARS" /></td>
				</center></tr>
			</c:forEach>
				<center><a class="button-left" href="/ecommerce-web/buscar/busqueda">Volver a busqueda</a></center>
		</tbody>
	</table>

</div>




