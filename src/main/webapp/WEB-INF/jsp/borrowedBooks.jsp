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

    <title>Available Books</title>

    <link href="${contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container">
    <br>
    <h2 class="bg-info" style="background-color: darkgrey" align="center">Books currently borrowed</h2><br>
    <c:choose>
        <c:when test="${borrowedBooks.size() > 0}">
            <table class="table table-bordered table-striped">
                <thead class="tab table-hover">
                <tr>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Return Date</th>
                    <th>Return Book</th>
                </tr>
                <c:forEach var="borrowedBook" items="${borrowedBooks}">
                </thead>
                <tbody>
                <td>${borrowedBook.isbn}</td>
                <td>${borrowedBook.title}</td>
                <td>${borrowedBook.author.name}</td>
                <td>${borrowedBook.category}</td>
                <td>${borrowedBook.returnDate}</td>
                <td><a href="<c:url value='/return-book/${borrowedBook.isbn}'/>">Return</a></td>
                </tbody>

                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p style="color: red">There are no borrowed books</p>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
<jsp:include page="common/footer.jsp"/>
