<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>

    <h2>Zarządzanie zadaniami</h2>
    <a href="${pageContext.request.contextPath}/adminExercisesAdd">Dodaj zadanie</a><br><br>
    <table>
        <thead>
        <tr class="border">
            <th>Tytuł zadania</th>
            <th>Opis zadania</th>
            <th>Akcje</th>
        </tr>
        </thead>
        <tbody>

        <!-- FOR EACH -->

        <c:forEach items="${exercises}" var="exercise" varStatus="loopStatus">
            <tr class="border">
                <td>${exercise.title}</td>
                <td>${exercise.description}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/adminExercisesEdit?id=${exercise.id}">Edytuj</a>
                    &nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/adminExercisesDelete?id=${exercise.id}">Usuń</a>
                </td>
            </tr>
        </c:forEach>

        <!-- /FOR EACH -->

        </tbody>
    </table>
</div>

<%@include file="WEB-INF/footer.jsp" %>