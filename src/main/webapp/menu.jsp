
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

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
        <p>Hello ${name}</p>

        <table class="table table-striped">
            <thead>
            <th>#</th>
            <th>Дисконт</th>
            <th>Название</th>
            <th>Цена</th>
            <th>ЦВес</th>

            </thead>
            <%--<c:forEach var="menu" items="${list}">--%>
                <tr>
                    <td>${menu.id}</td>
                    <td>${menu.name}</td>

                    <td>${menu.discount}</td>
                    <td>${menu.price}</td>
                    <td>${menu.weight}</td>

                </tr>
            <%--</c:forEach>--%>

        </table>
        <a class="btn btn-primary" href="\">На главную</a>


    </div>
</div>
</body>
</html>
