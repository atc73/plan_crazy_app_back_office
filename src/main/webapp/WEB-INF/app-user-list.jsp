<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Customers</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>App users</h1>

<div>
    <a class="btn btn-success"
       href="${pageContext.request.contextPath}/app-users/add">Ajouter un utilisateur</a>
</div>

<c:forEach items="${appUserList}" var="appUser">
    <ul>
        <li>${appUser.nickname}</li>
        <li>${appUser.firstName}</li>
        <li>${appUser.lastName}</li>
        <li>${appUser.address}</li>
        <li>${appUser.postcode}</li>
        <li>${appUser.city}</li>
        <li>${appUser.phoneNumber}</li>
        <li>${appUser.email}</li>
        <li>${appUser.isAdmin}</li>
        <li style="list-style: none;">
            <form method="post" action="${pageContext.request.contextPath}/app-users/delete">
                <input type="hidden" value="${appUser.appUserId}" name="appUserId">
                <button>Delete</button>
            </form>
        </li>
        <li style="list-style: none;">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/app-users/update?id=${appUser.appUserId}">Update</a>
        </li>
    </ul>
</c:forEach>

</body>
</html>

