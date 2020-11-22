<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 19/11/2020
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <%-- BootStrap CNN --%>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
            integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
            crossorigin="anonymous" >

    <title>Auto</title>
</head>
<body>

<%@include file="header.html" %>

<h1 align="center"> Ciao <c:out value="${name}"/> <c:out value="${lastname}"/> ecco l'elenco delle tue auto </h1>

<div class="container mb-3 mt-4">
    <div class="table-responsive">
        <table class="table table-bordered table-dark">
            <thead>
            <tr>
                <th scope="col">IDAuto</th>
                <th scope="col">Marcchio</th>
                <th scope="col">Modello</th>
                <th scope="col">Categoria</th>
                <th scope="col">Prezzo</th>
            </tr>
            </thead>
            <tbody>
          <%--  <c:forEach items="${cars}" var="car">
                <tr>
                    <td>${car.carId}</td>
                    <td>${car.brand}</td>
                    <td>${car.model}</td>
                    <td>${car.category}</td>
                    <td>${car.price} </td>
                </tr>
            </c:forEach> --%>

            </tbody>
        </table>
    </div>
</div>
</body>
</html>
