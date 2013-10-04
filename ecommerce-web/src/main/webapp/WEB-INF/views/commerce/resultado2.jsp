<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="hero-unit">
    <h2>Busqueda</h2>
        	<div style="text-align: center;" >
        		<form action="resultado2" method="POST">
					<input type="text" name="min" placeholder="Precio Minimo"/>
					<input type="text" name="max" placeholder="Precio Maximo"/>
					<select name="id">
					    <c:forEach items="${fabricantes}" var="fabricante" varStatus="i">
							<option value="${fabricante.id}"> ${fabricante.nombre} </option>
						</c:forEach>
					        
					</select>
					<input type= "submit" value="Buscar" class="btn"/>
				</form>
				<br/>
				<br/>
 				
    		</div>
    		
			<div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Producto</th>
							<th>Precio</th>
							<th>Fabricante</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="producto" varStatus="i">
							<tr>
								<td>${producto.nombre}</td>
								<td>${producto.precio}</td>
								<td>${producto.fabricante.nombre}</td>
							</tr>
						</c:forEach>
								
						<tr>
						</tr>
					</tbody>
				</table>		
			</div>
		
		
</div>