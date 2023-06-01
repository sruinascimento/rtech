<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<head>
    <title>Form | Categoria</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.min.css">

</head>

<body>
<header class="container">
    <h1> Atualização da Categoria </h1>
</header>
<main class="container">


    <form:form modelAttribute="data" class="formulario-cadastro" action="/admin/categories/${category.code()}" method="post">

        <input type="text" name="id" value="${category.id()}" hidden="hidden">

        <div class="form-group">
            <label for="name">Nome da Categoria</label>
            <input type="text" id="name" name="name" class="form-control" value="${category.name()}" placeholder="Digite o nome da categoria">
            <form:errors path="name" cssClass="text-danger" />



        </div>

            <input type="text" id="code" name="code" class="form-control" value="${category.code()}" hidden="hidden"
                   placeholder="por exemplo: desenvolvimento, mobile (não use letras maiúsculas, acentos ou caracteres especiais)">

        </div>

        <div class="checkbox">
            <label>
                <input type="checkbox" name="active" id="active"
                                <c:choose>
                                <c:when test="${category.active() eq 'ATIVA'}">
                                       checked
                                </c:when>
                                </c:choose>

                >Categoria ativa? <small id="mensagem"
                                                                                         class="form-text text-muted">Mostrar
                ou deixar de mostrar a categoria na listagem dos alunos,
                formações, etc</small>
            </label>
        </div>

        <div class="form-group">
            <label for="order">Ordem</label>
            <input type="number" id="order" name="order" class="form-control" min="1" max="20" value="${category.order()}"
                   placeholder="por exemplo: categoria de ordem 1 aparece antes da categoria de ordem 2">

        </div>

        <div class="form-group">
            <label for="studyGuide">Guia de estudo</label>
            <textarea class="form-control" rows="3" id="studyGuide" name="studyGuide"
                      placeholder="Um texto apontando para formações para ajudar pessoas perdidas">${category.studyGuide()}</textarea>
        </div>

        <div class="form-group">
            <label for="icon">Url do ícone</label>
            <input type="text" id="icon" name="iconPath" class="form-control" value="${category.iconPath()}"
                   placeholder="por exemplo: https://cdn.icon-icons.com/icons2/1070/PNG/512/darth-vader_icon-icons.com_76959.png"
            >
        </div>
        <div class="form-group">
            <label for="color" class="control-label">Cor </label>
            <input type="text" id="color" name="htmlColorCode" class="form-control" value="${category.htmlColorCode()}" placeholder="por exemplo: #fcc14a">
            <form:errors path="htmlColorCode" cssClass="text-danger" />
        </div>

        <input id="submit" type="submit" class="btn btn-success" value="Enviar">

    </form:form>

</main>
</body>

</html>
