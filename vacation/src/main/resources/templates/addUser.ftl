<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Додати користувача</title>
</head>
<body>
<h1>Додати користувача</h1>
<form action="/user/add" method="post">
    <label for="name">Ім'я:</label>
    <input type="text" id="name" name="name" value="${user.name!}" /><br/><br/>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="${user.email!}" /><br/><br/>

    <!-- Додайте інші поля за потреби -->
    <button type="submit">Додати</button>
</form>
</body>
</html>
