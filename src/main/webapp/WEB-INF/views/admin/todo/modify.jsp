<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Todo 수정하기</title>
    <meta name="viewport" content="width=device-width" , initial-scale="1.0">
</head>

<body>
<div class="card-body">
    <form action="/admin/todo/modify" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">번호</span>
            <input type="text" name="tno" class="form-control"
                   value='<c:out value="${dto.tno}"></c:out>' readonly>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">제목</span>
            <input type="text" name="title" class="form-control"
                   value='<c:out value="${dto.title}"></c:out>'>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">날짜</span>
            <input type="date" name="dueDate" class="form-control"
                   value='<c:out value="${dto.dueDate}"></c:out>'>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">작성자</span>
            <input type="text" name="writer" class="form-control"
                   value='<c:out value="${dto.writer}"></c:out>'>
        </div>

        <div    >
            <label class="form-check-label">
                완료여부 &nbsp;
            </label>
            <input class="form-check-input" type="checkbox"
                   name="finished" ${dto.finished?"checked":""}>
        </div>

        <div class="my-4">
            <div class="float-end">
                <button type="button" class="btn btn-danger">삭제하기</button>
                <button type="button" class="btn btn-primary">수정하기</button>
                <button type="button" class="btn btn-secondary">목록가기</button>
            </div>
        </div>

        <input type="hidden" name="page" value="${pageRequestDTO.page}">
        <input type="hidden" name="size" value="${pageRequestDTO.size}">
    </form>
</div>

<script>
    const formObj = document.querySelector("form");

    document.querySelector(".btn-danger").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();

        formObj.action = "/admin/todo/remove?${pageRequestDTO.link}"
        formObj.method = "post"

        formObj.submit()
    }, false)

    document.querySelector(".btn-primary").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();
        formObj.action="/admin/todo/modify?${pageRequestDTO.link}";
        formObj.method="post"

        formObj.submit()
    }, false)

    document.querySelector(".btn-secondary").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();

        self.location = "/admin/todo/list?${pageRequestDTO.link}";
    }, false)
</script>


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
</body>
</html>
