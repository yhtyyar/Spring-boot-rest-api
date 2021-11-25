<!DOCTYPE html>
<html>
<head>
    <title>Overlords</title>
</head>
<body>

<h1>Overlords</h1>

<hr>
<fieldset>
    <legend><h3>Список ТОП-10 молодых Повелителей</h3></legend>
    <#list youngestOverlordList as overlord>
        <div>
            <h4>${overlord.toString()}</h4>
        </div> <br>

    <#else>
        <h4>Нет Повелителей</h4>
    </#list>
</fieldset>
<br><br>

<form action="back" method="get">
    <input type="submit" value=" Назад "/>
</form>

</body>
</html>