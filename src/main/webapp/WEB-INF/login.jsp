<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1 id="login_title">Login</h1>

<c:if test="${loginFail}">
    <div role="alert">Bad credentials</div>
</c:if>

<form id="login_form" method="post" action="${pageContext.request.contextPath}/login">
    <label for="email">Email</label>
    <input id="email" type="text" name="email">
    <label for="password">Mot de passe</label>
    <input id="password" type="password" name="password">
    <input type="submit" value="Login">
</form>


</body>
</html>