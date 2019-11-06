<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <h2>Lista użytkowników grupy: ${group.name}</h2>
    <br>
    <table>
        <thead>
        <tr class="border">
            <th>Nazwa</th>
            <th>Akcje</th>
        </tr>
        </thead>
        <tbody>

        <!-- FOR EACH -->

        <c:forEach items="${users}" var="user" varStatus="loopStatus">
            <tr class="border">
                <td>${user.username}</td>
                <td><a href="${pageContext.request.contextPath}/userDetails?id=${user.id}">Szczegóły</a></td>
            </tr>
        </c:forEach>

        <!-- /FOR EACH -->

        </tbody>
    </table>
</div>

<%@include file="WEB-INF/footer.jsp" %>