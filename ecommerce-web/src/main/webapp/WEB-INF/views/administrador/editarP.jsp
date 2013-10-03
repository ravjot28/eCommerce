<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<h1>Editar producto</h1>

<form action="editarP" method="POST">
	<h3>Id: ${producto.id}</h3>
	<h3>Fabricante: ${producto.fabricante.nombre}</h3>
	Nombre: <input type="text" name="nombre" placeholder="Nombre" value="${producto.nombre}" />
	<br />
	Precio: <input type="number" name="precio" placeholder="Precio" value="${producto.precio}" />
	<br />
	<input type="hidden" name="id" value="${producto.id}" />
	
	<button class="btn btn-info">Guardar</button>
</form>