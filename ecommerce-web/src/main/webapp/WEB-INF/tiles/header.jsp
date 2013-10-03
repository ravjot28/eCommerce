<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">eCommerce</a>
        <div class="nav-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/ecommerce-web/commerce/index">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="/ecommerce-web/index/buscar">Busqueda Productos</a></li>
                <li><a href="/ecommerce-web/commerce/carrito">Carrito</a></li>
                <li><a href="/ecommerce-web/commerce/busqueda2">Busqueda Alternativa</a></li>
                <li><a href="/ecommerce-web/ordendecompra/user">Usuario Consulta</a></li>
                <li><a href="/ecommerce-web/ordendecompra/admin">Administrador</a></li>
                <li><a href="/ecommerce-web/ordendecompra/adminconfirmado">Administrador Consulta</a></li>
               <li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="/admin/administrador/mainAdmin">Main Admin</a>
                </sec:authorize>
                </li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <security:authorize access="!isAuthenticated()">
                    <li><a href='<s:url value="/signin"></s:url>'>Sign in</a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li><a href='<s:url value="/logout"></s:url>'>Logout (<security:authentication property="principal.username"/>)</a></li>
                </security:authorize>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>
