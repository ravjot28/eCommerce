<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div align="center">
	<h1>Usuario - (Ingrese su e-mail)</h1>
</div>
<br />
<div>
	<table class="table table-bordered">
		<tr>
			<form action="consultarComprasUser" method="get">
				<label>Ingrese su mail</label>
				<input type="email" name="email"/>
				<button type="submit">Acceder</button>
			</form>
		</tr>
	</table>
</div>

<div align="center">
	<h1>Usuario - Ver compras</h1>
</div>
<div>
	<table class="table table-bordered">
		<tr>
			<td>Id</td>
			<td>Usuario</td>
			<td>Productos</td>
			<td>Estado</td>	
		</tr>
		<c:forEach items="${compras}" var="compra">	
			<td>${compra.id}</td>
			<td>${compra.usuario.perfil}</td>
			<td>
			<div align="center">
				<c:forEach items="${compra.productos}" var="productosComprables">
					${productosComprables.producto.nombre}<br/>
				</c:forEach>
			</div>
			</td>
			<td>${compra.estadoCompra}</td>	
		</c:forEach>	
	</table>
</div>