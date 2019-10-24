<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="common/header.jsp"/>
<jsp:include page="common/navigation.jsp"/>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="container">

    <form:form method="post" modelAttribute="bookToAdd" class="form-signin" name="FrmAddBook">
        <h4 class="form-signin-heading">Book Management Web Application</h4>
        <spring:bind path="isbn">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="isbn" class="form-control" placeholder="ISBN"
                            autofocus="true" required=""></form:input>
                <form:errors path="isbn" cssClass="text-danger"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="title" class="form-control" placeholder="Title" required=""></form:input>
                <form:errors path="title" cssClass="text-danger"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="category">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="category">
                    <form:option value="Select category"/>
                    <c:forEach items="${categories}" var="category">

                        <form:option value="${category}">${category}</form:option>
                    </c:forEach>
                </form:select>
                <form:errors path="category" cssClass="text-danger"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="author">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="author">
                    <form:option value="Select author"/>
                    <c:forEach items="${authors}" var="author">
                        <form:option value="${author}">${author.name}  ${author.surname}</form:option>
                    </c:forEach>
                </form:select>
                <form:errors path="author" cssClass="text-danger"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        <br>

    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

<%@include file="common/footer.jsp" %>