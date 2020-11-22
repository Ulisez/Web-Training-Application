<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ulises Sanchez
  Date: 18/11/2020
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
            integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
            crossorigin="anonymous" >

    <title>Cars</title>

</head>

<body>

<header>
    <%@include file="./header.html" %>
</header>

<div class="jumbotron text-center">
    <h1 class="display-4" style="color:tomato;">Dealer</h1>
    <p class="lead">Questo è un semplice progetto di training per imparare le tecnologie JAVAEE.</p>
    <hr class="my-4" style="width:400px; background-color:tomato;">
    <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
    <p class="lead">
        <a class="btn btn-primary btn-lg" href="#" role="button">Le nostre Auto</a>
    </p>
</div>

<div class="container-fluid">
    <div class="row">
        <%-- form update user data   --%>
        <div class="col-lg-4">
            <h3 class="display-5 d-flex mb-4 justify-content-center">Aggiungi un Auto</h3>
            <form method="post" action="<c:url value="/car"/>">
                <div class="form-group">
                    <input type="hidden" class="form-control"  name="command" value="ADD">
                </div>
                <div class="form-group">
                    <label>Marchio</label>
                    <input type="text" class="form-control" placeholder="Inserire la marca" name="brand">
                </div>
                <div class="form-group">
                    <label>Modello</label>
                    <input type="text" class="form-control" placeholder="Inserire il modello" name="model">
                </div>
                <div class="form-group">
                    <label>Categoria</label>
                    <input type="text" class="form-control"  placeholder="Inserire la categoria" name="category">
                </div>
                <div class="form-group">
                    <label>Descrizione</label>
                    <input type="text" class="form-control"  placeholder="Descrizione" name="description">
                </div>
                <div class="form-group">
                    <label>Prezzo</label>
                    <input type="text" class="form-control"  placeholder="Inserire il prezzo" name="price">
                </div>
                <button type="submit" class="btn btn-dark">Aggiungi Auto</button>
                <button type="reset" class="btn btn-primary">Reset</button>
            </form>
        </div>

        <%-- table that show users data   --%>
        <div class="col-lg-8">
            <h2 class="display-5 d-flex mb-4 justify-content-center">Catalogo delle Auto</h2>
            <div class="container mb-3 mt-4">
                <div class="table-responsive ">
                    <table class="table table-dark">
                        <thead>
                        <tr>
                            <th scope="col">IDAuto</th>
                            <th scope="col">Marcchio</th>
                            <th scope="col">Modello</th>
                            <th scope="col">Categoria</th>
                            <th scope="col">Prezzo</th>
                            <th scope="col">Elimina</th>
                            <th scope="col">Dettagli</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${cars}" var="car">
                            <tr>
                                <td>${car.carId}</td>
                                <td>${car.brand}</td>
                                <td>${car.model}</td>
                                <td>${car.category}</td>
                                <td>${car.price}</td>
                                <td>
                                    <form method="post" action="<c:url value="/car"/>">
                                            <input type="hidden" class="form-control"  name="command" value="DELETE">
                                            <input type="hidden" name="carId" value="${car.carId}">
                                        <button class="btn bg-danger text-white" type="submit">Elimina</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="<c:url value="/car/detail"/>" method="post">
                                        <input type="hidden" name="carId" value="${car.carId}">
                                        <button class="btn bg-info text-white" type="submit">Dettagli</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<footer>
    <%@include file="./footer.html" %>
</footer>

</body>
</html>
