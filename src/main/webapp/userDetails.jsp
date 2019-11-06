<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <p>
        <a href="${pageContext.request.contextPath}/groupUsers?id=${user.groupId}">Powrót</a><br>
    </p>
    <h2>Szczegóły użytkownika: ${user.username}</h2>
    Nazwa: <b>${user.username}</b><br>
    Email: ${user.email}<br>
    <b>Dodane rozwiązania zadań:</b><br><br><br>

    <table>
        <thead>
        <tr class="border">
            <th>Tytuł zadania</th>
            <th>Data dodania</th>
            <th id="borderless"></th>
        </tr>
        </thead>
        <tbody>

        <!-- FOR EACH -->

        <c:forEach items="${exercises}" var="exercise" varStatus="loopStatus">
            <tr class="border">
                <td>${exercise.title}</td>
                <td>${solutions[loopStatus.count - 1].created}</td>
                <td><a href="${pageContext.request.contextPath}/solution?id=${solutions[loopStatus.count - 1].id}&userId=${user.id}">Szczegóły</a></td>

            </tr>
        </c:forEach>

        <!-- /FOR EACH -->

        </tbody>
    </table>
</div>

<%@include file="WEB-INF/footer.jsp" %>