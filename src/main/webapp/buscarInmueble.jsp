<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 22-06-2023
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<main>
    <section>
        <article class="b-form"></article>
        <form action="/buscarInmueble" method="post">
            <input name="direccion" placeholder="Direccion" type="text" required>
            <input name="ciudad" placeholder="Ciudad" type="text" required>
            <button type="submit">Buscar</button>
        </form>
    </section>
    <section class="r-busqueda">
        <table>
            <tr>
                <th>Construccion</th>
                <th>Precio</th>
                <th>Direccion</th>
            </tr>
            <c:forEach items="${inmuebles}" var="inmueble">
                <td><c:out value="${inmueble.getConstruccion}"></c:out>  </td>
                <td><c:out value="${inmueble.getPrecio}"></c:out></td>
                <td><c:out value="${inmueble.UbicacionGeografica().getDireccion()}">-</c:out>
                    <c:out value="${inmueble.UbicacionGeografica().getCiudad()}">-</c:out>
                </td>
            </c:forEach>
        </table>
    </section>
</main>
</body>
</html>
