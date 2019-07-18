<%--
  Created by IntelliJ IDEA.
  User: Mingwei
  Date: 2019-07-15
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Math Kingdom</title>
</head>
<body>
<div style="text-align:center;">
    <h2>Math Kingdom (JSP template)</h2>
    <br><br><br>
    <form action="${pageContext.request.contextPath}/calculate" method="post" style="text-align:center">
        <table style="margin-left: auto; margin-right: auto; margin-top: auto;">
            <col width="80">
            <col width="150">
            <tr>
                <td style="text-align:right">Variable a:</td>
                <td><input name="a" value="${a}"></td>
            </tr>
            <tr>
                <td style="text-align:right">
                    <select name="operator" value="${operator}">
                        <option value="0" <c:if test="${operator == '0'}">selected</c:if>>+</option>
                        <option value="1" <c:if test="${operator == '1'}">selected</c:if>>-</option>
                        <option value="2" <c:if test="${operator == '2'}">selected</c:if>>×</option>
                        <option value="3" <c:if test="${operator == '3'}">selected</c:if>>÷</option>
                    </select>
                </td>
                <td>
                </td>
            </tr>
            <tr>
                <td style="text-align:right">Variable b:</td>
                <td><input name="b" value="${b}"></td>
            </tr>
            <tr>
                <td style="text-align:right">Result:</td>
                <td><label>${res}</label></td>
            </tr>
        </table>
        <input type="submit" value="calculate"/>
    </form>
</div>
</body>
</html>
