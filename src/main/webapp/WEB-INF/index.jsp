<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listes</title>
</head>
<body>
<h1>
    Listes
</h1>
<br/>
<c:forEach var="liste" items="${listes}">
    <li class="list-group-item d-flex justify-content-between align-items-center">${liste.nom}
        <div>
            <a href="${pageContext.request.contextPath}/nouvelle?id=${liste.id}" class="badge" title="Editer la liste"><i class="material-icons">create</i></a>
            <a href="${pageContext.request.contextPath}/panier?id=${liste.id}" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
            <a href="${pageContext.request.contextPath}/listes?supprimer=${liste.id}" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
        </div>

    </li>
</c:forEach>
</body>
</html>