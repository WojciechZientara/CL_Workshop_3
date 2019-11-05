<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <p>
        <a href="${pageContext.request.contextPath}/">Powrót</a><br>
        <h2>Szczegóły rozwiązania zadania:</h2>
        ${solution.description}
    </p>
</div>

<%@include file="WEB-INF/footer.jsp" %>