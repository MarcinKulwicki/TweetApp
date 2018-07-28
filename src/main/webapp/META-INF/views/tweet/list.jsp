<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 27.07.18
  Time: 15:46
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
<ul>
    <c:forEach items="${tweets}" var="tmp">
        <li>
            ${tmp.tweet}
            <p><a href="${pageContext.request.contextPath}/tweet/list/user/add${tmp.id}">Edit Tweet</a></p>
            <%--<p><a href="${pageContext.request.contextPath}/author/form/delete/${tmp.id}">Delete Author</a></p>--%>
        </li>
    </c:forEach>
</ul>
</body>
</html>
