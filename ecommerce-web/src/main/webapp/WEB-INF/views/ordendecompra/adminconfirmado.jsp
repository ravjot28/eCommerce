<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div align="left">
	<a href="/ecommerce-web/ordendecompra/admin">Confirmar compras</a>	
</div>
<div align="center">
	<h1>Admin - Estas son las cuentas ya verificadas</h1>
</div>
<br />
<div>
	<table class="table table-striped">
		<tr>
			<td align="center">ID</td>
			<td align="center">Usuario</td>
			<td align="center">Producto</td>
			<td align="center">Estado</td>
		</tr>
		<c:forEach items="${compras}" var="compra">
			<tr>
				<td align="center">${compra.id}</td>
				<td align="center">${compra.usuario.perfil}</td>
				
				<td>
				<c:forEach items="${compra.productos}" var="productoComprable">
					<div align="center">${productoComprable.producto.nombre}<br/></div>
				</c:forEach>
				</td>
				<td align="center">${compra.estadoCompra}</td>
			</tr>
		</c:forEach>
	</table>
</div>