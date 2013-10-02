<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>


<center>
	<h1>Inicio</h1>
</center>
<p></p>
<div>
	<table class="table table-striped">
		<thead>

			<tr>
				<th></th>
				<th>Id</th>
				<th>Nombre</th>
				<th>Fabricante</th>
				<th>Precio</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="producto" varStatus="i">
				<tr>
					<td>${i.index+1}</td>
					<td>${producto.id}</td>
					<td>${producto.nombre}</td>
					<td>${producto.fabricante}</td>
					<td><fmt:formatNumber type="currency"
							value="${producto.precio}" currencyCode="ARS" /></td>
				</tr>
			</c:forEach>
	</table>

</div>




