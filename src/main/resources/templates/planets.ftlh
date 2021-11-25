<!DOCTYPE html>
<html>
<head>
    <title>Planets</title>
</head>
<body>

<h1>Planets</h1>


<fieldset>
    <legend><h3>Все Планеты</h3></legend>

    <#list planetList as planet>

        <div>
            <h4>ID: ${planet.id}  Название Планеты: ${planet.name}</h4>
            <form action="delete/${planet.id}" method="post">
                <input type="submit" value=" Уничтожить "/>
            </form>
        </div> <br>

    <#else>
        <h4> Планет нет </h4>
    </#list>
</fieldset>
<br><br>


<fieldset>
    <legend><h3> Добавление новой Планеты </h3></legend>

    <form action="create" method="post">
        <label> Название Планеты:
            <input type="text" name="name"/>
        </label><br><br>
        <input type="submit" value=" Добавить "/>
    </form>
</fieldset>
<br><br>

<form action="overlords" method="get">
    <input type="submit" value=" Перейти к Повелителям "/>
</form>


</body>
</html>