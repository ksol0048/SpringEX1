<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css">
<script src="/bootstrap/js/bootstrap.bundle.min.js"></script>

<html>
<head>
    <title>Todo List Register</title>
    <meta name="viewport" content="width=device-width", initial-scale="1.0">
</head>

<body>
<h1>Todo 등록</h1>
<div class="row">
    <div class="col">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                        <a class="nav-link" href="#">Feature</a>
                        <a class="nav-link" href="#">Pricing</a>
                        <a class="nav-link" href="#">Disabled</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>
<br>
<div class="card-body">
    <form action="/admin/todo/register" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">제목</span>
            <input type="text" name="title" class="form-control" placeholder="Title">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">날짜</span>
            <input type="date" name="dueDate" class="form-control" value="${today}">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">작성자</span>
            <input type="text" name="writer" class="form-control" placeholder="Writer">
        </div>
        여부사항: <input type="checkbox" name="finished">
        <div class="my-4">
            <div class="float-end">
                <button type="submit" class="btn btn-primary">등록</button>
                <button type="reset" class="btn btn-secondary">리셋</button>
            </div>
        </div>
    </form>

    <script>
        const serverValidResult = {}
        <c:forEach items="${errors}" var="error">
        serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
        </c:forEach>

        console.log(serverValidResult)
        let errorMessage = "";
        for (const field in serverValidResult) {
            if (serverValidResult.hasOwnProperty(field)) {
                errorMessage += field +':'+ serverValidResult[field]+'\n'
            }
        }

        if (errorMessage) {
            alert("검증 에러들 : \n" + errorMessage)
        }

        /*function setTodayDate(){
            const tody =new Date();
            const yyyy=today.getFullYear();
            const mm=String(today.getMonth()+1).padStart(2,'0');
            const dd=String(today.getDate()).padStart(2,'0');
            document.getElementById('dueDate')
        }*/
    </script>
</div>
</body>
</html>
