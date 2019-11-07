<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="WEB-INF/header.jsp" %>

<div>
    <h2>Dodaj użytkownika:</h2>
    <br>
    <form action="adminUsersAdd" method="post">
        <table>
            <tr>
                <td style="text-align: right">Nazwa użytkownika: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td class="colorless" style="text-align: right">Email: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td class="colorless"><input type="text" name="email"></td>
            </tr>
            <tr>
                <td style="text-align: right">Hasło: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td class="colorless" style="text-align: right">Grupa: &nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td class="colorless">
                    <select name="group">
                        <option value="0"></option>
                        <c:forEach items="${groups}" var="group" varStatus="loopStatus">
                            <option value="${group.id}">${group.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><br><input type="submit" value="Zapisz" style="float: right;"></td>
            </tr>
        </table>
    </form>

</div>

<%@include file="WEB-INF/footer.jsp" %>