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

<c:if test="${wrongPassword}">
    Wrong password
</c:if>

<ul>
    <c:forEach items="${user}" var="tmp">
        <li>
            ${tmp.email}
            ${tmp.password}
            <p><a href="${pageContext.request.contextPath}/user/add/${tmp.id}">Edit User</a></p>
            <%--<p><a href="${pageContext.request.contextPath}/author/form/delete/${tmp.id}">Delete Author</a></p>--%>
        </li>
    </c:forEach>
</ul>
</body>
</html>
