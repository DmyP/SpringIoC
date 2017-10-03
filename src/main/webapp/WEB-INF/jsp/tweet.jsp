
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="resources/style.css">
    <title>Title</title>
</head>
<h1>Tweet content: <br/> ${tweet}</h1>

<form action="newtweet" method="post">
    <fieldset>
        <label for="tweetMsg">Enter new message</label><br/>
        <textarea id="tweetMsg" name="tweetText" cols="50" rows="5"></textarea>
    </fieldset>
    <input type="submit" value="Create new message"/>
</form>

<form id="tweetList" action="tweetList" method="post">
    <input type="submit" value="Display all tweets"/>
</form>

<p>New Tweet:</p>
<p><c:out value="${newtweet.txt}"/></p>

<p>Tweet list:</p>
<p>
<table>
    <thead>
    <tr>
        <th>№</th><th>Message</th><th></th>
    </tr>
    </thead>

    <c:forEach items="${tweetList}" var="tweet" varStatus="h">
        <tr>
            <td>${h.index + 1}</td>
            <td>${tweet.txt}</td>
            <td><a href="<c:url value="editTweet?id=${tweet.tweetId}"></c:url>"><input type="submit" value="Edit"></a></td>
        </tr>
    </c:forEach>
</table>
</p>
</body>
</html>