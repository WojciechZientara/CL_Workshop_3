<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <h2>Edytuj zadanie:</h2>
    <br>
    <form action="adminExercisesEdit" method="post">
        <table>
            <tr>
                <td>Tytuł zadania: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="text" name="exerciseTitle" value="${exercise.title}"></td>
            </tr>
            <tr>
                <td class="colorless">Opis zadania: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td class="colorless"><input type="text" name="exerciseDescription" value="${exercise.description}"></td>
            </tr>
            <tr>
                <td><input type="text" name="exerciseId" value="${exercise.id}" style="display: none;"></td>
                <td><br><input type="submit" value="Zapisz" style="float: right;"></td>
            </tr>
        </table>
    </form>

</div>

<%@include file="WEB-INF/footer.jsp" %>