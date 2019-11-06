<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <h2>Lista grup</h2>
    <br>
    <table>
        <thead>
        <tr class="border">
            <th>Nazwa grupy</th>
            <th>Akcje</th>
        </tr>
        </thead>
        <tbody>

        <!-- FOR EACH -->

        <c:forEach items="${userGroups}" var="group" varStatus="loopStatus">
            <tr class="border">
                <td>${group.name}</td>
                <td><a href="${pageContext.request.contextPath}/groupUsers?id=${group.id}">Użytkownicy</a></td>
            </tr>
        </c:forEach>

        <!-- /FOR EACH -->

        </tbody>
    </table>
</div>

<%@include file="WEB-INF/footer.jsp" %>