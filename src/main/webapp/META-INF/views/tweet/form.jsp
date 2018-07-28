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
<c:import url="../fragments/header.jsp"/>
<p><a href="${pageContext.request.contextPath}/user/list"><< Back</a></p>
<c:forEach items="${error}" var="err">
    ${err.propertyPath} ${err.message} <br/>
</c:forEach>

<form:form method="post" modelAttribute="tweets">
    <form:errors path="*"/>
    <form:input path="tweet" placeholder="text..."/>
    <input type="submit">
</form:form>

</body>
</html>
