<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add app user</title>
</head>
<body>

<h1>Add app user</h1>
<form method="post" action="/app-users/add">
  <label for="nickname">Nickname :</label>
  <input id="nickname" type="text" name="nickname">

  <label for="firstName">First name :</label>
  <input id="firstName" type="text" name="firstName">

  <label for="lastName">Last name :</label>
  <input id="lastName" type="text" name="lastName">

  <label for="address">Address :</label>
  <input id="address" type="text" name="address">

  <label for="postcode">Postcode :</label>
  <input id="postcode" type="number" name="postcode">

  <label for="city">City :</label>
  <input id="city" type="text" name="city">

  <label for="phoneNumber">Phone number :</label>
  <input id="phoneNumber" type="text" name="phoneNumber">

  <label for="email">Email :</label>
  <input id="email" type="text" name="email">

  <label for="password">Password :</label>
  <input id="password" type="text" name="password">

  <fieldset>
    <div>
      <input type="radio" id="admin" name="isAdmin" value="true">
      <label for="admin">Admin</label>
    </div>
    <div>
      <input type="radio" id="user" name="isAdmin" value="false" checked>
      <label for="user">Utilisateur</label>
    </div>
  </fieldset>

  <button>Ajouter un utilisateur / admin</button>
</form>

</body>
</html>
