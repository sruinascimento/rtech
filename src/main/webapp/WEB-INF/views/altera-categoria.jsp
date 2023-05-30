<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Form | Categoria</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/cadastro.css">

</head>
<body>
<header>
    <h1> RTech - Alteração Categoria </h1>
</header>
<main>

    <form class="formulario-cadastro" action="/admin/categories/${category.code()}" method="post">

        <input type="text" name="id" value="${category.id()}" hidden="hidden">

        <label for="name">Nome da Categoria</label>
        <input type="text" id="name" name="name" value="${category.name()}" required>

        <%--        <label for="code">Código</label>--%>
        <input type="text" id="code" name="code" value="${category.code()}" hidden="hidden" required>

        <label for="description">Descrição</label>
        <textarea class="size-text-area" name="description" id="description" required>
            ${category.description().trim()}
        </textarea>

        <label for="studyGuide">Guia de Estudo</label>
        <textarea class="size-text-area" name="studyGuide" id="studyGuide" required>
            ${category.studyGuide().trim()}
        </textarea>
        <div class="container-input-radio">
            <label for="inativo">Curso Inativo</label>
            <input type="radio" id="inativo" name="active" value="INATIVA"
            <c:choose>
            <c:when test="${category.active() eq 'INATIVA'}">
                   checked
            </c:when>
            </c:choose>
            >
        </div>

        <div class="container-input-radio">
            <label for="ativo">Curso Ativo</label>
            <input type="radio" id="ativo" name="active" value="ATIVA"
            <c:choose>
            <c:when test="${category.active() eq 'ATIVA'}">
                   checked
            </c:when>
            </c:choose>
            >
        </div>

        <label for="order">Ordem</label>
        <input type="text" id="order" name="order" value="${category.order()}">

        <label for="icon">Url da Imagem</label>
        <input type="text" id="icon" name="iconPath" value="${category.iconPath()}" required>

        <label for="color">Cor em html</label>
        <input type="text" id="color" name="htmlColorCode" value="${category.htmlColorCode()}" required>

        <input id="submit" type="submit" value="Cadastrar">

    </form>
</main>
<footer>
    <p> Rui Nascimento</p>
    <div class="content-contact">
        <a href="https://github.com/sruinascimento" target="_blank">
            <i class="fa-brands fa-square-github"></i> Github
        </a>
        <a href="https://www.linkedin.com/in/sruinascimento/" target="_blank">
            <i class="fa-brands fa-linkedin"></i> Linkedin
        </a>
    </div>
</footer>
</body>
</html>
