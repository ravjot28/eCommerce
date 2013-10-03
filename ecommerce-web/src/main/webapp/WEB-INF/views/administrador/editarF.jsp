<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<h1>Editar producto</h1>

<form action="editarF" method="POST">
	<h3>Id: ${fabricante.id}</h3>
	Nombre: <input type="text" name="nombre" placeholder="Nombre" value="${fabricante.nombre}" />
	<br />
	<input type="hidden" name="id" value="${fabricante.id}" />
	
	<button class="btn btn-success">Guardar</button>
</form>