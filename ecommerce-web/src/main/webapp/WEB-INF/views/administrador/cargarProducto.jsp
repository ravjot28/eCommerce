<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h2 class="remarco text-muted">Agregar un producto</h2>
	<div>
		<form action="createP" method="post">
			<label for="nombre" class="text-muted">Producto</label> 
			<input id="nombre" type="text" name="nombre" /> 
			
			<label for="idFabricante" class="text-muted">Fabricante</label>
			<select name="idFabricante" id="idFabricante">
				<c:forEach items="${fabricantes}" var="fabricante">
	    			<option value="${fabricante.id}" >${fabricante.nombre}</option>
	    		</c:forEach>

			</select>
			
			<label for="precio" class="text-muted">Precio</label>
			<input id="precio" type="number" name="precio" min="0" />
			
			<input type="hidden" value="producto" name="tipo"/>
			
			<input type="submit" class="btn btn-success"/>
		</form>
	</div>
	





	<div>
		<table class="table table-condensed text-muted">
			<thead class="remarco">
				<tr class="htabla">
					<th>Nombre</th>
					<th>Precio</th>
					<th>Fabricante</th>
					<th>Modificacion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productos}" var="producto">
					<tr>
						<td class="text-muted">${producto.nombre}</td>
						<td class="text-muted">${producto.precio}</td>
						<td class="text-muted">${producto.fabricante.nombre}</td>
						<td>
							<form action="delete" method="post">
								<input type="hidden" value="${producto.id}" name="id" /> <input
									type="hidden" value="producto" name="tipo" /> <input
									type="submit" value=Eliminar class="btn btn-danger btn-xs" />
							</form>
							<form action="editarP" method="GET">
								<input type="hidden" name="id" value="${producto.id}" />
								<button class="btn btn-warning btn-xs">Editar</button>
							</form>
						</td>
					</tr>

				</c:forEach>
			</tbody>

		</table>

	</div>
	
	
	
<a href="mainAdmin"><button class="btn btn-success">ATRAS</button></a>
</body>
</html>