<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="heager.jsp"/>
<body>

<section>
    <h1>Users</h1>
    <hr>
    <a href="users/create">Create User</a>
    <hr>

    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>Update</th>
            <th>delete</th>
            <th>select</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">

            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><a href="users/update?id=${user.id}">Update</a></td>
                <td><a href="users/delete?id=${user.id}">Delete</a></td>
                <td><a href="users/delete?id=${user.id}">Select</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
