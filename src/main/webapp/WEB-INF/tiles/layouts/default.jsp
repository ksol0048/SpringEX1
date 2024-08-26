<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사이트 제목</title>

    <style>
        .header {
            background-color : red;
            height : 150px;
        }

        .contents {
            background-color : green;
            height : 500px;
        }

        .footer {
            background-color : blue;
            height : 100px;
        }
    </style>
</head>
<body>
<!-- Page Header -->
<tiles:insertAttribute name="header" />

<!-- Page Contents -->
<tiles:insertAttribute name="body" />

<!-- Page Footer -->
<tiles:insertAttribute name="footer" />

</body>
</html>