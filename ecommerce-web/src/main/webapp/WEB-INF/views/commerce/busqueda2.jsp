<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="hero-unit">
    <h2>Busqueda</h2>
        	<div style="text-align: center;" >
        		<form action="busqueda" method="GET">
						<input type="number" name="min" placeholder="Precio Minimo" value=""/>
						<input type="number" name="max" placeholder="Precio Maximo" value=""/>
					<select>
					    <c:forEach items="${fabricantes}" var="fabricante" varStatus="i">
						     <option> NombreMarca </option>
						</c:forEach>
					</select>
				</form>
				<br/>
				<br/>
				<input type= "submit"/> 				
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
									<td>producto.nombre</td>
									<td>producto.precio</td>
									<td>producto.fabricante.getNombre()</td>
								</tr>
							</c:forEach>
						<tr>
						</tr>
					</tbody>
				</table>		
			</div>
		
		
</div>