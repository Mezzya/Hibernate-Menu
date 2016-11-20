

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=utf-8" %>

<html>
<head>
    <title>Квартирный менеджер</title>
    <meta charset="utf-8"  />
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="my_body">
        <h2>Menu resstoran</h2>
        <p>Hello</p>

        <table class="table table-striped">
            <thead>
            <th>#</th>
            <th>Название</th>
            <th>Дисконт</th>
            <th>Цена</th>
            <th>Вес</th>

            </thead>
            <%--@elvariable id="list" type="java.util.List<ua.com.e2k.Menu>"--%>
            <c:forEach var="menu" items="${list}">
                <tr>
                    <td>${menu.id}</td>
                    <td>${menu.name}</td>

                    <td>${menu.discount}</td>
                    <td>${menu.price}</td>
                    <td>${menu.weight}</td>

                </tr>
            </c:forEach>

        </table>
        <a class="btn btn-primary" href="\">На главную</a>
        <a href=«#myModal»role=«button»class=«btn»data-toggle=«modal»>Добавить</a>

        <div class=«modal»id=«myModal»tabindex=«-1″role=«dialog»aria-labelledby=«myModalLabel»aria-hidden=«true»>
        <div class=«modal-header»>
        <button type=«button»class=«close»data-dismiss=«modal»aria-hidden=«true»>?</button>
        <h3 id=«myModalLabel»>Заголовок модального элемента</h3>
    </div>
    <div class=«modal-body»>
    <p>Некое изящное тело…</p>
</div>
<div class=«modal-footer»>
<button class=«btn»data-dismiss=«modal»aria-hidden=«true»>Закрыть</button>
<button class=«btn btn-primary»>Сохранить изменения</button>
</div>
</div>


    </div>
</div>
</body>
</html>
