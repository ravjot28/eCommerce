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


	<h2 class="text-muted remarco">Agregar un fabricante</h2>
	<div>
		<form action="createF" method="post">
			<label for="nombre" class="text-muted">Marca</label> 
			<input id="nombre" type="text" name="nombre" /> 

			<input type="hidden" value="fabricante" name="tipo"/>
			
			<input type="submit" value="AGREGAR" class="btn btn-success"/>
		</form>
	</div>
	




	<h4 class="remarco text-muted">Lista de fabricantes</h4>
	
 <div>
		<table class="table table-condensed text-muted">
			<thead class="remarco">
				<tr class="htabla">
					<th>Nombre</th>
					<th>Modificacion</th>
					<th>Comentar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fabricantes}" var="fabricante">
					<tr>
						<td class="text-muted">${fabricante.nombre}</td>
						<td>
							<form action="delete" method="post">
								<input type="hidden" value="${fabricante.id}" name="id" /> <input
									type="hidden" value="fabricante" name="tipo" /> <input
									type="submit" value=Eliminar class="btn btn-danger btn-xs" />
							</form>
						
							<form action="editarF" method="GET">
								<input type="hidden" name="id" value="${fabricante.id}" />
								<button class="btn btn-warning btn-xs" >Editar</button>
							</form>
							<form action="verProd" method="GET">
								<input type="hidden" name="id" value="${fabricante.id}" />
								<button class="btn btn-info btn-xs" >Ver Productos</button>
							</form>
							<form action="//localhost:8080/ecommerce-web/comentario/index" method="GET">
								<input type="hidden" name="id" value="${fabricante.id}" />
								<input type="hidden" name="flag" value="false"/>
								<button class="btn btn-default btn-xs" >Comentar</button>
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
