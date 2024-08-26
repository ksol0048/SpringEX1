<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User List Page</title>
    <meta name="viewport" content="width=device-width" , initial-scale="1.0">
</head>

<body>
<h1>회원 목록</h1>
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
<div class="row content">
    <div class="col">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">검색</h5>
                <form action="/admin/user/user-list" method="get">
                    <input type="hidden" name="size" value="${pageRequestDTO.size}">
                    <div class="mb-3">
                        <input type="checkbox" name="types" value="i" ${pageRequestDTO.checkType("i")?"checked":""}>ID
                        <input type="checkbox" name="types" value="n" ${pageRequestDTO.checkType("n")?"checked":""}>이름
                        <input type="text" name="keyword" class="form-control" value="${pageRequestDTO.keyword}">
                    </div>
                    <div class="input-group mb-3 dueDateDiv">
                        <input type="date" name="from" class="form-control" value="${pageRequestDTO.from}">
                        <input type="date" name="to" class="form-control" value="${pageRequestDTO.to}">
                    </div>
                    <div class="input-group mb-3">
                        <div class="float-end">
                            <button class="btn btn-primary" type="submit">검색</button>
                            <button class="btn btn-info clearBtn" type="reset">Reset</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="card-body">
    <h5 class="card-title">Speial title treatment</h5>
    <table class="table">
        <thead>
        <th scope="col">ID</th>
        <th scope="col">이름</th>
        <th scope="col">비밀번호</th>
        <th scope="col">가입일자</th>
        </thead>
        <c:forEach items="${responseDTO.dtoList}" var="duser">
            <tr>
                <th><a href="/admin/user/user-read?user_id=${duser.user_id}&${pageRequestDTO.link}" class="text-decoration-none"><c:out value="${duser.user_id}"/></a>
                </th>
                <td><c:out value="${duser.user_name}"/></td>
                <td><c:out value="${duser.user_pw}"/></td>
                <td><c:out value="${duser.register_date}"/></td>
            </tr>
        </c:forEach>
        <%--<c:forEach items="${userList}" var="duser">
            <tr>
                <th scope="row">${duser.user_id}</th>
                <td><c:out value="${duser.user_name}"/></td>
                <td><c:out value="${duser.user_pw}"/></td>
                <td><c:out value="${duser.register_date}"/></td>
            </tr>
        </c:forEach>--%>
    </table>

    <div class="float-end">
        <ul class="pagination flex-wrap">
            <c:if test="${responseDTO.prev}">
                <li class="page-item">
                    <a class="page-link" data-num="${responseDTO.start-1}">Previous</a>
                </li>
            </c:if>
            <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                <li class="page-item ${responseDTO.page ==num?"active":""}">
                    <a class="page-link" data-num= "${num}">${num}</a>
                </li>
            </c:forEach>
            <c:if test="${responseDTO.next}">
                <li class="page-item">
                    <a class="page-link" data-num="${responseDTO.end+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </div>
    <script>
        document.querySelector(".clearBtn").addEventListener("click", function (e) {
            e.preventDefault();
            e.stopPropagation();

            self.location="/admin/user/user-list"
        },false)

        document.querySelector(".pagination").addEventListener("click", function (e) {
            e.preventDefault();
            e.stopPropagation();

            const target = e.target

            if (target.tagName !== 'A') {
                return
            }

            const num = target.getAttribute("data-num")

            const formObj = document.querySelector("form");

            formObj.innerHTML+=`<input type='hidden' name='page' value='\${num}'>`

            formObj.submit();
        }, false)
    </script>
</div>
</body>
</html>
