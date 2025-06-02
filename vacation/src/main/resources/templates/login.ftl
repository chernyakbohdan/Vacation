<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="log-in" method="post">
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email" required><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" required><br><br>
    <input type="submit" value="login">
</form>
<#if error??>
    <p>${error}</p>
    </#if>
<a href="/menu">Back to Menu</a>
</body>
</html>