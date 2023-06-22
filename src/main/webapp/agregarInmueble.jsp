<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 22-06-2023
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar inmueble</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<main>
    <article>
        <section class="formulario">
            <%
                String mensaje = (String) request.getAttribute("status");
                if (mensaje != null && !mensaje.isEmpty()) {
            %>
            <h2><%= mensaje %></h2>
            <%
                }
            %>
            <form action="/agregarInmueble" method="post">
                <input name="tipoConstruccion" placeholder="Tipo Construccion" type="text" required>
                <input name="precio" placeholder="Precio" type="number" required>
                <input name="ciudad" placeholder="Ciudad" type="text" required>
                <input name="direccion" placeholder="Direccion" type="text">
                <button type="submit">Agregar</button>
            </form>
            <a href="index.jsp">Volver</a>

        </section>
    </article>
</main>
</body>
</html>
