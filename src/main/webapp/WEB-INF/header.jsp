<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/assets/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<a id="plan_crazy_app_title" href="${pageContext.request.contextPath}/welcome">PlanCrazyApp</a>

<c:choose>
    <c:when test="${not empty sessionScope.email}">
        <form id="logout_form" method="post" action="${pageContext.request.contextPath}/logout">
            <input type="submit" value="Logout">
        </form>
    </c:when>

</c:choose>
</body>
</html>
