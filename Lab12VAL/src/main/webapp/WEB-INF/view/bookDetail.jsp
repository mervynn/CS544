<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Car</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/test.css"/>
</head>
<body>
<c:if test="${msg == 'Update'}">
    <c:set var="action" value="../books/${book.id}" />
</c:if>
<c:if test="${msg == 'Add'}">
    <c:set var="action" value="../books" />
</c:if>
<%--@elvariable id="book" type="edu.mum.cs544.domain.Book"--%>
<form:form modelAttribute="book" action="${action}" method="post">
    <table>
        <tr>
            <td>Title:</td>
            <td>
                <form:input path="title"/>
            </td>
            <td>
                <form:errors path="title" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>ISBN:</td>
            <td>
                <form:input path="ISBN"/>
            </td>
            <td>
                <form:errors path="ISBN" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Author:</td>
            <td>
                <form:input path="author"/>
            </td>
            <td>
                <form:errors path="author" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>
                <form:input path="price"/>
            </td>
            <td>
                <form:errors path="price" cssClass="error"/>
            </td>
        </tr>
    </table>
    <input type="submit"/>
</form:form>
<c:if test="${msg == 'Update'}">
    <form:form action="delete?bookId=${book.id}">
        <button type="submit">Delete</button>
    </form:form>
</c:if>
</body>
</html>