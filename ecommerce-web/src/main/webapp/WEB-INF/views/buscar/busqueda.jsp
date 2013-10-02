<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="hero-unit">
	<h2>Buscar</h2>
	<div>
	<h4>${mensaje}</h4>

		<form action=busqueda method="POST">
			<label for="fabricante_nombre">Fabricante</label> <input
				id="fabricante_nombre" type="text" name="nombre" /> <label
				for="minimo">por Precio :</label> <br> <label
				for="precio_minimo">minimo</label> <input id="precio_minimo"
				type="text" name="minimo" /> <label for="precio_maximo">maximo</label>
			<input id="precio_maximo" type="text" name="maximo" />
			<a href= "/ecommerce-web/buscar/resultado" class="btn btn-success btn-lg"  type="button" >Buscar</a>
		</form>
	</div>


</div>