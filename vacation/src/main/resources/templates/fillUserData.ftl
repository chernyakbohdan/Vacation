<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Завершіть реєстрацію</title>
</head>
<body>
<h1>Додайте необхідні дані</h1>
<form action="fill_data" method="post">
    <input type="hidden" name="id" value="${user.id!}" />

    <label for="email">Email:</label>
    <input type="text" id = "email" name="email" value="${user.email!}" readonly /><br/><br/>

    <label for="name">Ваше ім'я:</label>
    <input type="text" id="name" name="name" value="${user.name!}" /><br/><br/>

    <label for="appointment">Посада:</label>
    <input type="text" id="appointment" name="appointment" value="${user.appointment!}" /><br/><br/>

    <label for="experience">Experience:</label>
    <input type="number" id="experience" name="experience" value="${user.experience!}" /><br/><br/>

    <label for="dateOfBirth">Дата народження:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth" value="${user.dateOfBirth!}" /><br/><br/>

    <label for="phone">Your phone number:</label>
    <input type="tel" id="phone" name="phone" value="${user.phone!}" /><br/><br/>

    <button type="submit">Надіслати</button>
</form>
</body>
</html>