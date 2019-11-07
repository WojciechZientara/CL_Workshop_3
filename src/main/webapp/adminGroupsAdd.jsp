<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <h2>Dodaj grupę:</h2>
    <br>
    <form action="adminGroupsAdd" method="post">
        <table>
            <tr>
                <td>Nazwa działu: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="text" name="groupName"></td>
            </tr>
            <tr>
                <td class="colorless"></td>
                <td class="colorless"><br><input type="submit" value="Zapisz" style="float: right;"></td>
            </tr>
        </table>
    </form>

</div>

<%@include file="WEB-INF/footer.jsp" %>