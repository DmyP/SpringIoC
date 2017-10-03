<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${t}" var="meal">
        <jsp:useBean id="meal" scope="page" type=""/>
        <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
            <td>
                    <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                    <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                    ${fn:formatDateTime(meal.dateTime)}
            </td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
            <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>