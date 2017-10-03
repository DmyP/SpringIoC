<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        form {
            margin-left: 20px;
        }
        fieldset {
            border: none;
            margin-bottom: 20px;
        }
        body {
            background: linear-gradient(deepskyblue, lightgreen);;
        }
        table{
            margin: 0 auto;
        }
        th {
            font-size: 2vw;

        }
        tr {
            font-size: 1vw;

        }
        input[type="submit"] {
            padding: 6px 18px 5px;
            margin-left: 14px;
            background: linear-gradient(white, lightskyblue);
            border: 1px solid white;
            border-radius: 4px;
            color: gray;
            font-weight: bold;
            font-family: "Book Antiqua";
        }
        input[type="submit"]:hover {
            background: linear-gradient(white, lightskyblue);
            cursor: pointer;
        }
        textarea {
            border: 1px solid gray;
            border-radius: 4px;
            margin-top: 10px;
        }
        h1 {
            text-align: center;
            font-size: 6vw;
        }

        h2 {
            text-align: center;
            font-size: 4vw;
        }
        #tweetList {
            margin-top: 15px;
        }

    </style>
</head>
