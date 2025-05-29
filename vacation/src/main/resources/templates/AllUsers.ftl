<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Список користувачів</title>
</head>
<body>
<h1>Список користувачів</h1>
<ul>
    <#list users as user>
        <li>ID: ${user.id} - Ім'я: ${user.name}</li>
    </#list>
</ul>
</body>
</html>
