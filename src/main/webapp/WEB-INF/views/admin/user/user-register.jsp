<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css">
<script src="/bootstrap/js/bootstrap.bundle.min.js"></script>

<html>
<body>
<h1>회원가입</h1>
<div class="card-body">
    <form action="/admin/user/user-register" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">ID</span>
            <input type="text" name="user_id" class="form-control" placeholder="ID를 입력하세요">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">이름</span>
            <input type="text" name="user_name" class="form-control" placeholder="이름을 입력하세요">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">비밀번호</span>
            <input type="password" name="user_pw" class="form-control" placeholder="비밀번호를 입력하세요">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">가입일</span>
            <input type="date" name="register_date" class="form-control" value="${today}" disabled>
        </div>
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
