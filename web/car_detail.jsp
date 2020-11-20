<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 20/11/2020
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dettagli Auto</title>
</head>
<body>
<%@include file="header.html" %>

<h1 class="display-5 d-flex mb-4 justify-content-center" >Dettagli dell'auto selezionata</h1>
<div class="container-fluid d-flex justify-content-center mr-auto align-items-center bg-light" style="min-height:500px; ">

    <div class="row">
        <div class="col">
            <div class="card" style="">
                <div class="card-body">
                    <h5 class="card-title">${carDetail.brand}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">${carDetail.model}</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.
                        build on the card title and make up the bulk of the card's content.</p>
                    <div class="card-header bg-dark text-white">
                        Specifiche tecniche
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><span class="font-weight-bold">Motore:</span> Cras justo odio </li>
                        <li class="list-group-item"><span class="font-weight-bold">Colore:</span> Cras justo odio </li>
                        <li class="list-group-item"><span class="font-weight-bold">Anno di produzione:</span> Cras justo odio </li>
                        <li class="list-group-item"><span class="font-weight-bold">Carburante:</span> Cras justo odio </li>
                    </ul>
                </div>
                <div class="card-footer"> <span class="font-weight-bold">Prezzo:</span>${carDetail.price}
                </div>
            </div>
        </div>
        <div class="col d-flex align-items-center justify-content-center flex-column">
            <form action="<c:url value="/car/purchase"/>" method="post" style="width:100%;">
                <div class="form-group">
                    <input type="hidden" name="carId" value="${carDetail.carId}">
                </div>
                <div class="form-group">
                    <label class="text-center">Selezionare il cliente</label>
                    <select class="form-control" name="userSelected">
                        <option>Cliente</option>
                        <c:forEach items="${userList}" var="user">
                            <option value="${user.name} ${user.userId}">${user.name} ${user.lastname}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-dark text-white">Comprare Auto</button>
            </form>
        </div>
    </div>
</div>
<%@include file="footer.html" %>
</body>
</html>
