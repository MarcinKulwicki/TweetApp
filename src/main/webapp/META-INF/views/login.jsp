<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 27.07.18
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form method="post">
        <input type="text" name="username" placeholder="username">
        <input type="password" name="password" placeholder="Password">
        <input type="submit" value="Login">
    </form>

    <c:if test="${forgotPassword}">
        <form:form method="post" modelAttribute="user">
            <form:input path="email" placeholder="Email"/>
            <form:input path="username" placeholder="Username"/>
            <input type="password" name="newPassword" placeholder="New password">
            <input type="submit">
        </form:form>
    </c:if>

    <p><h5><a href="${pageContext.request.contextPath}/login/forgotPassword">Forgot password?</a></h5></p>
    <p><h5><a href="${pageContext.request.contextPath}/login/add">Add User</a></h5></p>
</body>
</html>
