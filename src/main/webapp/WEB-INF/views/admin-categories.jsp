<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ADMIN</title>
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.css">
</head>

<body>

<div class="container espacamento-div">
    <h1> RTECH CATEGORIAS </h1>
    <a href="/admin/categories/new" target="_blank" class="btn btn-primary">Nova categoria</a>
</div>
<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Código</th>
            <th>Status</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.name()}</td>
                <td>${category.code()}</td>
                <td>${category.active()}</td>
                <td>
                    <a href="/admin/subcategories/${category.code()}" class="decoracao-hiperlink " target="_blank">Subcategorias</a>
                </td>
                <td>
                    <a href="/admin/categories/${category.code()}" class="btn btn-default active" target="_blank">Editar</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<script src="bootstrap-3.3/js/bootstrap.min.js"></script>
</body>

</html>