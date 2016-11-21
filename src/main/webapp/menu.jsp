

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=utf-8" %>

<html>
<head>
    <title>Ресторан prog.kiev.ua</title>
    <meta charset="utf-8"  />
    <link href="/style.css" rel="stylesheet">

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>

<div class="container">
    <div class="my_body">
        <h2>Меню ресторана</h2>
        <p>${err}</p>
        <table class="table table-striped">
            <thead>
            <th>#</th>
            <th>Название</th>
            <th>Дисконт</th>
            <th>Цена, грн</th>
            <th>Вес, гр</th>
            <th>Управление</th>

            </thead>
            <%--@elvariable id="list" type="java.util.List<ua.com.e2k.Menu>"--%>
            <c:forEach var="menu" items="${list}">
                <tr>
                    <td>${menu.id}</td>
                    <td>${menu.name}</td>

                    <td>
                        <c:choose>
                            <c:when test="${menu.discount}"><span class="glyphicon glyphicon-ok"></span></c:when>
                            <c:otherwise><span class="glyphicon glyphicon-remove"></span></c:otherwise>
                        </c:choose>


                    </td>
                    <td>${menu.price}</td>
                    <td>${menu.weight}</td>
                    <td><a class="btn btn-danger" href="\del?id=${menu.id}">Х</a> <a class="btn btn-success" href="\addbasket?id=${menu.id}">+</a></td>

                </tr>
            </c:forEach>

        </table>
        <a class="btn btn-primary" href="\menu">Все меню</a>
        <!-- Button trigger modal -->
        <!-- Кнопка, вызывающее модальное окно -->
        <a href="#myModal" class="btn btn-primary" data-toggle="modal">Добавить</a>
        <a href="#filterForm" class="btn btn-primary" data-toggle="modal">Фильтр</a>

        <br><br>
        <h2>Корзина заказа</h2>
        <h3>Общий вес корзины ${allWeight}</h3>
        <p>${errb}</p>
        <table class="table table-striped">
            <thead>
            <th>#</th>
            <th>Название</th>
            <th>Дисконт</th>
            <th>Цена, грн</th>
            <th>Вес, гр</th>
            <th>Управление</th>

            </thead>
            <%--@elvariable id="list" type="java.util.List<ua.com.e2k.Menu>"--%>
            <c:forEach var="menub" items="${basket}">
                <tr>
                    <td>${menub.id}</td>
                    <td>${menub.name}</td>

                    <td>
                        <c:choose>
                            <c:when test="${menub.discount}"><span class="glyphicon glyphicon-ok"></span></c:when>
                            <c:otherwise><span class="glyphicon glyphicon-remove"></span></c:otherwise>
                        </c:choose>


                    </td>
                    <td>${menub.price}</td>
                    <td>${menub.weight}</td>
                    <td><a class="btn btn-danger" href="\delbasket?id=${menub.id}">Х</a></td>

                </tr>
            </c:forEach>

        </table>



        <!-- HTML-код модального окна -->
        <div id="myModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Заголовок модального окна -->
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Добавление нового элемента в меню</h4>
                    </div>
                    <!-- Основное содержимое модального окна -->
                    <div class="modal-body">

                        <form id="add" class="form" action="/add" method="get">
                            <div class="form-group">
                                <label for="name">Название блюда</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                            </div>
                            <div class="form-group">
                                <label for="price">Стоимость</label>
                                <input type="text" class="form-control" id="price" name="price" placeholder="Price">
                            </div>
                            <div class="form-group">
                                <label for="weight">Вес</label>
                                <input type="text" class="form-control" id="weight" name="weight" placeholder="Weight">
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="discont" value="true"> Действует ли скидка
                                </label>
                            </div>




                        </form>
                    </div>
                    <!-- Футер модального окна -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                        <button type="submit" class="btn btn-primary" form="add">Добавить</button>
                    </div>
                </div>
            </div>
            </div>
        <div id="filterForm" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Заголовок модального окна -->
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Фильтр</h4>
                        </div>
                        <!-- Основное содержимое модального окна -->
                        <div class="modal-body">

                            <form id="filter" class="form" action="/filter" method="get">
                                <div class="form-group">
                                    <label for="name">Стоимость от</label>
                                    <input type="text" class="form-control" id="from" name="from" value="${param.from}" placeholder="от">
                                </div>
                                <div class="form-group">
                                    <label for="price">Стоимость до </label>
                                    <input type="text" class="form-control" id="to" name="to" placeholder="до" value="${param.to}">
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio"<c:if test="${(param.discount) == 'all'}" > checked</c:if>  name="discount" value="all">Все
                                    </label>
                                </div>

                                <div class="radio">
                                    <label>
                                        <input type="radio" name="discount" value="true" <c:if test="${(param.discount) == 'true'}" > checked</c:if>>Со скидкой
                                    </label>
                                </div>
                                <div class="radio">
                                     <label>
                                         <input type="radio" name="discount" value="false" <c:if test="${(param.discount) == 'false'}" > checked</c:if>>Без скидки
                                     </label>
                                </div>




                            </form>

                        </div>
                        <!-- Футер модального окна -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                            <button type="submit" class="btn btn-primary" form="filter">Отфильтровать</button>
                        </div>
                    </div>
                </div>
                </div>
    </div>


</div>




</body>
</html>
