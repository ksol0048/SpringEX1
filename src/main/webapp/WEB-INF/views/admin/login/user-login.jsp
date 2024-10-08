<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Login</title>

    <!-- Custom fonts for this template-->
    <link href="/startbootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/startbootstrap/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
<%--                        <div class="row">--%>
<%--                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>--%>
<%--                            <div class="col-lg-6">--%>
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">로그인</h1>
                                    </div>
                                    <form class="user" action="/admin/login/user-login" method="post">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                   name="user_id"
                                                id="user_id" aria-describedby="emailHelp"
                     인                           placeholder="ID 입력">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                   name="user_pw"
                                                id="user_pw" placeholder="비밀번호 입력">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">ID 저장</label>
                                            </div>
                                        </div>
                                        <button class="btn btn-primary btn-user btn-block" type="submit">로그인</button>
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a id="forget" class="small" href="forgot-password">비밀 번호 찾기</a>
                                    </div>
                                    <div class="text-center">
                                        <a id="register" class="small">회원가입</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
<script>
    document.querySelector("#register").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();

        self.location = "/admin/user/user-register";
    }, false)
</script>
    <!-- Bootstrap core JavaScript-->
    <script src="/startbootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="/startbootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/startbootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/startbootstrap/js/sb-admin-2.min.js"></script>

</body>

</html>