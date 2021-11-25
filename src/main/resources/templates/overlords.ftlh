<!DOCTYPE html>
<html>
<head>
    <title>Overlords</title>
</head>
<body>

<h1>Overlords</h1>

<fieldset>
    <legend><h3>Список всех Повелителей</h3></legend>
    <#list overlordList as overlord>

        <div>
            <h4>${overlord.toString()}</h4>
            <form action="update/${overlord.id}" method="post">
                <label> Добавить Планету для правления по ID:
                    <input type="number" name="planet_id"/>
                </label>
                <input type="submit" value=" Добавить "/>
            </form>
        </div> <br>

    <#else>
        <h4>Повелителей нет</h4>
    </#list>
</fieldset>
<br><br>


<fieldset>
    <legend> <h3> Добавление нового Повелителя </h3> </legend>

    <form action="create" method="post">
        <label> Имя Повелителя:
            <input type="text" name="name"/>
        </label> <br><br>

        <label> Возраст Повелителя:
            <input type="number" name="age"/>
        </label> <br><br>

        <input type="submit" value=" Добавить "/>
    </form>
</fieldset>
<br><br>


<fieldset>
    <legend> <h3> Найти всех Повелителей бездельников, которые прохлаждаются и не управляют никакими Планетами </h3>
    </legend>

    <form action="idlers" method="get">
        <input type="submit" value=" Найти "/>
    </form>
</fieldset>
<br><br>


<fieldset>
    <legend> <h3> Отобразить ТОП 10 самых молодых Повелителей </h3> </legend>

    <form action="youngest" method="get">
        <input type="submit" value=" Отобразить "/>
    </form>
</fieldset>
<br><br>

<form action="planets" method="get">
    <input type="submit" value=" Перейти к Планетам "/>
</form>

</body>
</html>