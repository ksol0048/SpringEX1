<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Todo List Register</title>
</head>
<body>
<h1>Todo List Register</h1>
<form action="/todo/register" method="post">
    <div>
        Title: <input type="text" name="title">
    </div>
    <div>
        DueDate: <input type="date" name="dueDate" value="2024-08-14">
    </div>
    <div>
        Writer: <input type="text" name="writer">
    </div>
    <div>
        Finished: <input type="checkbox" name="finished">
    </div>
    <div>
        <button type="submit">Register</button>
    </div>
</form>
</body>
</html>
