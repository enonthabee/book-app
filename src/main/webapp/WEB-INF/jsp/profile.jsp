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
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>User Profile</title>

    <link href="${contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container">
    <table class="table table-hover">
        <thead class="tab table-hover">
        <tr>
            <th>Name:</th>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th>Surname:</th>
            <td>${user.surname}</td>
        </tr>

        <tr>
            <th>Email:</th>
            <td>${user.email}</td>
        </tr>
        <tr>
            <th>Cellphone:</th>
            <td>${user.cellNo}</td>
        </tr>
        <tr>
            <th>Role:</th>
            <td>${user.role}</td>
        </tr>
        </thead>
    </table>
    <c:if test="${user.role == 'ADMIN'}">
        <div class="">
            <a href="/users" class="nav navbar-brand">All Users</a>
        </div>
    </c:if>

</div>

</body>
</html>
<jsp:include page="common/footer.jsp"/>
