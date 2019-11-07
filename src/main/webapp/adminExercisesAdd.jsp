<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <h2>Dodaj zadanie:</h2>
    <br>
    <form action="adminExercisesAdd" method="post">
        <table>
            <tr>
                <td>Tytuł zadania: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="text" name="exerciseTitle"></td>
            </tr>
            <tr>
                <td class="colorless">Opis zadania: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td class="colorless"><input type="text" name="exerciseDescription"></td>
            </tr>
            <tr>
                <td></td>
                <td><br><input type="submit" value="Zapisz" style="float: right;"></td>
            </tr>
        </table>
    </form>

</div>

<%@include file="WEB-INF/footer.jsp" %>