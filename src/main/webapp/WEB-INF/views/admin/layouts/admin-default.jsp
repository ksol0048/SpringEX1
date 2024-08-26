<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>병원관리시스템</title>
    <title:insertAttribute name="admin-common"/>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">
    <title:insertAttribute name="admin-sidebar"/>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <title:insertAttribute name="admin-body"/>
        </div>
        <!-- End of Main Content -->
        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <title:insertAttribute name="admin-footer"/>
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

<title:insertAttribute name="admin-logout-modal"/>
<title:insertAttribute name="admin-bootstrap"/>


</body>

</html>