<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>Main Menu</h1>

<div>
    <a href="/registration"><button>Register New User</button></a>
    <a href="/log-in"><button>Login</button></a>
</div>

<h2>Registered Users</h2>
<table border="1">
    <thead>
    <tr>
        <th>Emails</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <#-- This section will be populated by the backend with user data -->
    <#if getUsers??>
        <#list getUsers as user>
            <tr>
                <td>${user.email}</td>
                <td>${user.age}</td>
            </tr>
        </#list>
    <#else>
        <tr>
            <td colspan="1">No users registered yet.</td>
        </tr>
    </#if>
    </tbody>
</table>

</body>
</html>