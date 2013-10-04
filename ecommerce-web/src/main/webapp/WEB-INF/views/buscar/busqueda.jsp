<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="hero-unit">
	<h2>Buscar</h2>

		<form action=resultados method="POST">
			<label for="fabricante_nombre">Fabricante</label> <input
				id="fabricante_nombre" type="text" name="nombre" /> <label
				for="minimo">por Precio :</label> <br> <label
				for="precio_minimo">minimo</label> <input id="precio_minimo"
				type="text" name="minimo" value="0"/> <label for="precio_maximo">maximo</label>
			<input id="precio_maximo" type="text" value="0" name="maximo" />
			<input class="button-left" type="submit" class="btn btn-success btn-lg"  value="Buscar"/>
		</form>
</div>