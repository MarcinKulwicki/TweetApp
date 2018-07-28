<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 28.07.18
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="fragments/header.jsp"/>

<c:forEach items="${tweets}" var="tmp">
    <li>
            ${tmp.tweet}
            ${user[tmp.id].username}
            <%--<p><a href="${pageContext.request.contextPath}/author/form/delete/${tmp.id}">Delete Author</a></p>--%>
    </li>
</c:forEach>

</body>
</html>
