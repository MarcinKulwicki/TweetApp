<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 27.07.18
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${error}" var="err">
    ${err.propertyPath} ${err.message} <br/>
</c:forEach>

<form:form method="post" modelAttribute="user" action="/user/add">
    <form:errors path="*"/>
    <form:input path="username" placeholder="First Name"/>
    <form:input path="email" placeholder="Email"/>
    <form:password path="password" placeholder="password"/>
    ${pass}
    <input type="submit">
</form:form>

</body>
</html>
