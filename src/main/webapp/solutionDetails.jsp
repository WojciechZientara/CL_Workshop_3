<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <p>
        <c:choose>
        <c:when test="${userId == null}">
            <a href="${pageContext.request.contextPath}/">Powrót</a><br>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/userDetails?id=${userId}">Powrót</a><br>
        </c:otherwise>
        </c:choose>

        <h2>Szczegóły rozwiązania zadania:</h2>
        ${solution.description}
    </p>
</div>

<%@include file="WEB-INF/footer.jsp" %>