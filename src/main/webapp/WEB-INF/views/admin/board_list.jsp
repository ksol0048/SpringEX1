<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>병원관리시스템</title>
    <jsp:include page="layouts/admin-common.jsp"/>


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">
    <jsp:include page="layouts/admin-sidebar.jsp"/>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <jsp:include page="${content}.jsp"/>

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <jsp:include page="layouts/admin-footer.jsp"/>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<jsp:include page="layouts/admin-logout-modal.jsp"/>
<jsp:include page="layouts/bootstrap.jsp"/>


</body>

</html>