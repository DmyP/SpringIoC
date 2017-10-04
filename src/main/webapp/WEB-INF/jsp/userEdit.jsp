<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="heager.jsp"/>
<body>

<section>
    <jsp:useBean id="user" type="ua.rd.domain.User" scope="request"/>
    <h1>${user.isNew() ? 'Create User' : 'Edit User'}</h1>
    <hr>
    <form method="post" action="redirect:/users">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt>User Name</dt>
            <dd><input type="text" value="${user.name}" name="name"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
