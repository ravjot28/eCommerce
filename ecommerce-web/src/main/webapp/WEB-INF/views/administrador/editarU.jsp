<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<h1>Editar usuario</h1>

<form action="editarU" method="POST">
	<h3>Id: ${account.id}</h3>
	Email: <input type="text" name="email" value="${account.email}" />
	<br />
	<input type="hidden" name="id" value="${account.id}" />
	
	<button class="btn btn-success">Guardar</button>
</form>