<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <table>
        <thead>
        <tr class="border">
            <th>Tytuł zadania</th>
            <th>Autor rozwiązania</th>
            <th>Data dodania</th>
            <th id="borderless"></th>
        </tr>
        </thead>
        <tbody>

        <!-- FOR EACH -->

        <c:forEach items="${recentSolutions}" var="solution" varStatus="loopStatus">
            <tr class="border">
                <td>${solutionsExercises[loopStatus.count - 1].title}</td>
                <td>${solutionsUsers[loopStatus.count - 1].username}</td>
                <td>${solution.created}</td>
                <td><a href="${pageContext.request.contextPath}/solution?id=${solution.id}">Szczegóły</a></td>
            </tr>
        </c:forEach>

        <!-- /FOR EACH -->

        </tbody>
    </table>
</div>

<%@include file="WEB-INF/footer.jsp" %>