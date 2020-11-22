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

    <link rel="stylesheet" href="/web/META-INF/resources/css/style.css">

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
    </div>
</div>


<%-- container for show operation in dinamically mode  --%>


<!-- model pop-up senction -->
<div id="updateModal" class="modal">
    <!-- Modal content -->
    <div class="modal-content">
        <div class="modal-header bg-dark text-white">
            <h2>Update</h2>
            <span class="close">&times;</span>
        </div>
        <!-- The section form into the modal pop-up -->
        <div class="modal-body">
            <form method="post" action="<c:url value="/user/saveorupdate"/>">
                <div class="form-group">
                    <input type="hidden"  id="inputid" name="userId">
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="inputName" placeholder="Inserire il nome" name="name">
                </div>
                <div class="form-group">
                    <label>Cognome</label>
                    <input type="text" class="form-control" id="inputLastName" placeholder="Inserire il cognome" name="lastname">
                </div>
                <div class="form-group">
                    <label>Indirizzo</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="Inserire l'indirizzo" name="address">
                </div>
                <div class="form-group">
                    <label>Numero telefonico</label>
                    <input type="text" class="form-control" id="inputPhone" placeholder="Inserire il numero" name="phone">
                </div>
                <button type="submit" class="btn btn-dark">Aggiorna</button>
            </form>
        </div>
        <!- The footer section into the modal pop-up ->
        <div class="modal-footer bg-dark text-white">
            <h3>Aggiorna il cliente</h3>
        </div>
    </div>
</div>




<div class="container-fluid">
    <div class="row">
        <%-- form update user data   --%>
        <div class="col-lg-4">
            <h1 class="display-5 d-flex mb-4 justify-content-center" >Aggiungi un nuovo cliente</h1>
            <form method="post" action="<c:url value="/user/saveorupdate"/>">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" placeholder="Inserire il nome" name="name">
                </div>
                <div class="form-group">
                    <label>Cognome</label>
                    <input type="text" class="form-control" placeholder="Inserire il cognome" name="lastname">
                </div>
                <div class="form-group">
                    <label>Indirizzo</label>
                    <input type="text" class="form-control"  placeholder="Inserire l'indirizzo" name="address">
                </div>
                <div class="form-group">
                    <label>Numero telefonico</label>
                    <input type="text" class="form-control"  placeholder="Inserire il numero" name="phone">
                </div>
                <button type="submit" class="btn btn-dark">Aggiungi</button>
                <button type="reset" class="btn btn-primary">Reset</button>
            </form>
        </div>

            <%-- table that show users data   --%>
        <div class="col-lg-8">
            <h1 class="display-5 d-flex mb-4 justify-content-center" >Lista dei nostri clienti</h1>
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
                                    <button class="btn bg-warning text-white" type="button" onclick="openModel(['${user.name}','${user.lastname}',
                                            '${user.address}', '${user.phone}', '${user.userId}'])">Aggiorna</button>

                                </td>
                                <td>
                                    <c:set var="name" value="${user.name}"></c:set>
                                    <form method="post" action="<c:url value="/user/delete"/>">
                                        <input type="hidden" name="userId" value="${user.userId}">
                                        <button class="btn bg-danger text-white" type="submit" id="${name}">Elimina</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="<c:url value="/user/list/cars"/>" method="post">
                                        <input type="hidden" name="userId" value="${user.userId}">
                                        <button class="btn bg-info text-white" type="submit">Auto</button>
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


<%-- direttiva per includere il footer  --%>
<footer>
    <%@include file="footer.html" %>
</footer>

<script type="text/javascript">

    var modal = document.getElementById("updateModal");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
     function openModel(userdata) {
         document.getElementById('inputName').value = '' +userdata[0];
         document.getElementById('inputLastName').value = '' +userdata[1];
         document.getElementById('inputAddress').value = '' +userdata[2];
         document.getElementById('inputPhone').value = '' +userdata[3];
         document.getElementById('inputid').value = '' +userdata[4];
         modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    function alertOperation(username){
       window.alert( username + "Eliminato");
    }

</script>
</body>
</html>
