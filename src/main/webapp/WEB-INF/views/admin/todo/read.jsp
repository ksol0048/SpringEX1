<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Todo 상세보기</title>
    <meta name="viewport" content="width=device-width" , initial-scale="1.0">
</head>

<body>
<div class="card-body">

    <div class="input-group mb-3">
        <span class="input-group-text">번호</span>
        <input type="text" name="tno" class="form-control"
               value='<c:out value="${dto.tno}"></c:out>' readonly>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">제목</span>
        <input type="text" name="title" class="form-control"
               value='<c:out value="${dto.title}"></c:out>' readonly>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">날짜</span>
        <input type="date" name="dueDate" class="form-control"
               value='<c:out value="${dto.dueDate}"></c:out>' readonly>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">작성자</span>
        <input type="text" name="writer" class="form-control"
               value='<c:out value="${dto.writer}"></c:out>' readonly>
    </div>

    <div class="form-check">
        <label class="form-check-label">
            완료여부
        </label>
        <input class="form-check-input" type="checkbox"
               name="finished" ${dto.finished?"checked":""} disabled>
    </div>

    <div class="my-4">
        <div class="float-end">
            <button type="button" class="btn btn-primary">수정하기</button>
            <button type="button" class="btn btn-secondary">목록가기</button>
        </div>
    </div>
</div>

<script>
    document.querySelector(".btn-primary").addEventListener("click", function (e) {
        self.location = "/admin/todo/modify?tno=${dto.tno}&${pageRequestDTO.link}";
    }, false)

    document.querySelector(".btn-secondary").addEventListener("click", function (e) {
        self.location = "/admin/todo/list?${pageRequestDTO.link}";
    }, false)
</script>
</body>
</html>
