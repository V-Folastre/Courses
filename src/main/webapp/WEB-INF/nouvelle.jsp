<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nouvelle</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/e293f8832a.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="col-8 offset-2 text-center">
        <form action="${pageContext.request.contextPath}/nouvelle" method="post">
            <c:if test="${listeCourse == null}">
                <label for="nom_liste">Liste : </label>
                <input type="text" name="nom_liste" id="nom_liste">
            </c:if>
            <c:if test="${listeCourse != null}">
                <p>${listeCourse.nom}</p>
                <input name="id_liste" type="hidden" value="${listeCourse.id}">
                <c:forEach var="article" items="${listeCourse.articles}">
                    <ul class="list-group col-4 offset-4">
                        <li class="list-group-item text-center">
                            <p>${article.nom}</p>
                        </li>
                    </ul>
                </c:forEach>
            </c:if>
            <br>
            <label for="article">Article : </label>
            <input type="text" name="nom_article" id="article">
            <input type="submit" value="Ajouter">
        </form>
    </div>
</div>
</body>
</html>
