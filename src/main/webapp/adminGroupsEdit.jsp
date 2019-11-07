<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <h2>Edytuj grupę:</h2>
    <br>
    <form action="adminGroupsEdit" method="post">
        <table>
            <tr>
                <td>Nazwa działu: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>
                    <input type="text" name="groupName" value="${group.name}">
                    <input type="text" name="groupId" value="${group.id}" style="display: none">
                </td>
            </tr>
            <tr>
                <td class="colorless"></td>
                <td class="colorless"><br><input type="submit" value="Zapisz" style="float: right;"></td>
            </tr>
        </table>
    </form>

</div>

<%@include file="WEB-INF/footer.jsp" %>