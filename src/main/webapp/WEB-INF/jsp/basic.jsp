<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add a course</title>

    <link href="${contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="post" modelAttribute="calculator" class="form-signin" name="FrmCalc">
        <h2 class="form-signin-heading">Basic Calculator</h2>
        <c:if test="${answer != null}">
            <strong><p style="color: green">Your answer is: ${answer}</p></strong>
        </c:if>
        <spring:bind path="num1">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="num1" class="form-control" placeholder="First number"
                            autofocus="true"></form:input>
                <form:errors path="num1" cssClass="text-danger"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="calculationRequested">
            <form:select path="calculationRequested">
                <form:option value="+">-- Please Select --</form:option>
                <form:option value="+">+</form:option>
                <form:option value="-">-</form:option>
                <form:option value="*">*</form:option>
                <form:option value="/">/</form:option>
            </form:select>
        </spring:bind>

        <spring:bind path="num2">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="num2" class="form-control" placeholder="Second number"
                            autofocus="true"></form:input>
                <form:errors path="num2" cssClass="text-danger"></form:errors>
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

<%@ include file="common/footer.jsp" %>
