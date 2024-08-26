<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="card-body">

    <div class="input-group mb-3">
        <span class="input-group-text">ID</span>
        <input type="text" name="user_id" class="form-control"
               value='${dto.user_id}' readonly>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">이름</span>
        <input type="text" name="user_name" class="form-control"
               value="${dto.user_name}" readonly>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">가입일자</span>
        <input type="date" name="register_date" class="form-control"
               value="${dto.register_date}" disabled>
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
        self.location = "/admin/user/user-modify?user_id=${dto.user_id}&${pageRequestDTO.link}";
    }, false)

    document.querySelector(".btn-secondary").addEventListener("click", function (e) {
        self.location = "/admin/user/user-list?${pageRequestDTO.link}";
    }, false)
</script>
