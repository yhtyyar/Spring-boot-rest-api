<!DOCTYPE html>
<html>
<head>
    <title>Overlords</title>
</head>
<body>

<h1>Overlords</h1>

<fieldset>
    <legend><h3>Список всех Повелителей бездельников</h3></legend>
    <#list idlersOverlordList as overlord>
        <div>
            <h4>${overlord.toString()}</h4>
            <form action="update-idlers/${overlord.id}" method="post">
                <label> Добавить Планету для правления по ID:
                    <input type="number" name="planet_id"/>
                </label>
                <input type="submit" value=" Добавить "/>
            </form>
        </div> <br>
    <#else>
        <h4>Все повелители заняты</h4>
    </#list>
</fieldset>
<br><br>


<form action="back" method="get">
    <input type="submit" value=" Назад "/>
</form>

</body>
</html>