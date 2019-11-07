<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@include file="WEB-INF/header.jsp" %>

<div>

    <h2>Zarządzanie użytkownikami</h2>
    <a href="${pageContext.request.contextPath}/adminUsersAdd">Dodaj użytkownika</a><br><br>
    <table>
        <thead>
        <tr class="border">
            <th>Nazwa użytkownika</th>
            <th>Email</th>
            <th>Hasło</th>
            <th>Grupa</th>
            <th>Akcje</th>
        </tr>
        </thead>
        <tbody>

        <!-- FOR EACH -->

        <c:forEach items="${users}" var="user" varStatus="loopStatus">
            <tr class="border">
                <td>${user.username}</td>
                <td>${user.email}</td>
                <c:set var = "fullPass" value = "${user.password}"/>
                <c:set var = "shortPass" value = "${fn:substring(fullPass, 0, 20)}" />
                <td>${shortPass}...</td>
                <td>${groups[loopStatus.count - 1].name}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/adminUsersEdit?id=${user.id}">Edytuj</a>
                    &nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/adminUsersDelete?id=${user.id}">Usuń</a>
                </td>
            </tr>
        </c:forEach>

        <!-- /FOR EACH -->

        </tbody>
    </table>
</div>

<%@include file="WEB-INF/footer.jsp" %>