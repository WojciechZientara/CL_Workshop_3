<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
<%--    <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet" type="text/css">--%>
    <style><%@include file="/assets/style.css"%></style>
    <title>Szkoła programowania</title>
</head>
<body>
    <header>
        <div>
            <table>
                <tr>
                    <td><a href = "${pageContext.request.contextPath}/">Strona główna</a>&nbsp;&nbsp;</td>
                    <td><a href = "${pageContext.request.contextPath}/groups">Grupy</a>&nbsp;&nbsp;</td>
                    <td><a href = "${pageContext.request.contextPath}/panelAdmin">Panel administratora</a></td>
                </tr>
            </table>
        </div>
    </header>