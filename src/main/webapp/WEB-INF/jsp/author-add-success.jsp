<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="common/header.jsp"/>
<jsp:include page="common/navigation.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Author Registration Success</title>

    <link href="${contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container">
    <br>
    <h2 class="bg-info" style="background-color: darkgrey" align="center">Author Registration Successful</h2><br>

    <h3 style="color: green">Author <strong>${authorToAdd.name}</strong> added successfully</h3><br>

</div>

</body>
</html>
<jsp:include page="common/footer.jsp"/>
