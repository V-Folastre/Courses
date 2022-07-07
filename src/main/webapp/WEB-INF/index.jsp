<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/e293f8832a.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="row">
    <h1 class="col-6 offset-3 text-center">
        Listes de courses
    </h1>
</div>
<br/>
<div class="container">
    <c:forEach var="liste" items="${listes}">
        <ul class="list-group col-4 offset-4">
            <li class="list-group-item text-center">
                <span class="text-start">
                    <a class="link-primary" href="#">${liste.nom}</a>
                </span>
                &nbsp
                <span class="text-end">
                    <!-- pageContext.request.contextPath est le nom du projet -->
                    <!-- <i></i> concerne les icones de FontAwesome -->
                    <a class="link-primary" href="${pageContext.request.contextPath}/nouvelle?id=${liste.id}"><i
                            class="fa-solid fa-pen"></i></a>
                    <a class="link-primary" href="${pageContext.request.contextPath}/panier?id=${liste.id}"><i
                            class="fa-solid fa-cart-shopping"></i></a>
                    <a class="link-primary" href="${pageContext.request.contextPath}/listes?supprimer=${liste.id}"><i
                            class="fa-solid fa-trash"></i></a>
                </span>
            </li>
        </ul>
    </c:forEach>
    <hr>
    <a href="${pageContext.request.contextPath}/nouvelle"><i class="fa-solid fa-list"></i>&nbsp; Ajouter une liste de
        courses</a>
</div>
</body>
</html>