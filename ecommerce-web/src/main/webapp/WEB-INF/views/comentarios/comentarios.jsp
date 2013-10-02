<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div><h3>COMENTARIOS</h3></div>
	"${nombre}"
<table class="table table-hover " >
<tbody>
<c:forEach items="${Comentarios}" var="comentario" varStatus="i">
<tr>
	<td>${comentario.usuario.nombre}</td>
	<td>${comentario.usuario.nombre}</td>
	
	<td colspan="2"><input type="submit" value="block"></td> 

</tr>

</c:forEach>

</tbody>
</table>


</body>
</html>