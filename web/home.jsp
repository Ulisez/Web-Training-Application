<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 17/11/2020
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Web Application Training</title>

    <%-- BootStrap CNN --%>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous" >

    <%-- CNN font awesone for icons--%>
    <script src="https://kit.fontawesome.com/90add562c4.js" crossorigin="anonymous"></script>

    

</head>

<body>

<%-- --%>
<c:url value="/car" var="carUrl" />

<%-- Direttiva per il includere il header all'interno della home--%>
<%@include file="header.html" %>

<%-- banner bootstrap--%>
<div class="jumbotron">
  <h1 class="display-4">Web Training</h1>
  <p class="lead">Questo è un semplice progetto di training per imparare le tecnologie JAVAEE.</p>
  <hr class="my-4">
    <p>Abbiamo a disposizione un catalogo enorme di auto</p>
    <div class="container d-flex justify-content-center ">
        <a class="btn btn-primary btn-lg mr-md-3 " href="${carUrl}" role="button">Visualizza le auto</a>
        <a class="btn btn-primary btn-lg" href="#" role="button">Aggiungi utente</a>
    </div>
</div>

<%-- container for show operation in dinamically mode  --%>

<%-- table that show users data   --%>
<h1 class="display-4 d-flex mb-4 justify-content-center" >Lista dei nostri clienti</h1>

<div class="container mb-3 mt-4">
    <div class="table-responsive">
    <table class="table">
        <thead class="thead-dark">
        <tr>
          <th scope="col">id</th>
          <th scope="col">Nome</th>
          <th scope="col">Cognome</th>
          <th scope="col">Indirizzo</th>
          <th scope="col">Telefono</th>
          <th scope="col">Aggiorna</th>
          <th scope="col">Elimina</th>
          <th scope="col">Mostra Auto</th>
          </tr>
       </thead>
     <tbody>

     <c:forEach items="${users}" var="user">
         <tr>
             <td>${user.userId}</td>
             <td>${user.name}</td>
             <td>${user.lastname}</td>
             <td>${user.address}</td>
             <td>${user.phone} </td>
             <td>
                     <%-- URL action Da modificare, mi serviva per verificare il funzionamento --%>
             <form action="/Web_Training_Application_war_exploded" method="post">
                 <input type="hidden" name="userId" value="${user.name}">
                 <button class="btn bg-warning text-white" type="submit">Aggiorna</button>
             </form>
             </td>
             <td>
                 <form action="/" method="post">
                     <input type="hidden" name="userId" value="${user.name}">
                     <button class="btn bg-danger text-white" type="submit">Elimina</button>
                 </form>
             </td>
             <td>
                 <form action="/" method="post">
                     <input type="hidden" name="userId" value="${user.name}">
                     <button class="btn bg-info text-white" type="submit">Auto</button>
                 </form>
             </td>
         </tr>
     </c:forEach>

     </tbody>
    </table>
    </div>
</div>

<p><c:out value="${user.name}"/></p>

<%-- direttiva per includere il footer  --%>
<footer>
    <%@include file="footer.html" %>
</footer>
</body>
</html>
