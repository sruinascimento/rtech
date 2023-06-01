<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Form | Categoria</title>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <link rel="stylesheet" href="../../css/reset.css">--%>
<%--    <link rel="stylesheet" href="../../css/style.css">--%>
<%--    <link rel="stylesheet" href="../../css/cadastro.css">--%>

<%--</head>--%>
<%--<body>--%>
<%--<header>--%>
<%--    <h1> RTech - Alteração Categoria </h1>--%>
<%--</header>--%>
<%--<main>--%>

<%--    <form class="formulario-cadastro" action="/admin/categories/${category.code()}" method="post">--%>

<%--        <input type="text" name="id" value="${category.id()}" hidden="hidden">--%>

<%--        <label for="name">Nome da Categoria</label>--%>
<%--        <input type="text" id="name" name="name" value="${category.name()}" required>--%>

<%--        &lt;%&ndash;        <label for="code">Código</label>&ndash;%&gt;--%>
<%--        <input type="text" id="code" name="code" value="${category.code()}" hidden="hidden" required>--%>

<%--        <label for="description">Descrição</label>--%>
<%--        <textarea class="size-text-area" name="description" id="description" required>--%>
<%--            ${category.description().trim()}--%>
<%--        </textarea>--%>

<%--        <label for="studyGuide">Guia de Estudo</label>--%>
<%--        <textarea class="size-text-area" name="studyGuide" id="studyGuide" required>--%>
<%--            ${category.studyGuide().trim()}--%>
<%--        </textarea>--%>
<%--        <div class="container-input-radio">--%>
<%--            <label for="inativo">Curso Inativo</label>--%>
<%--            <input type="radio" id="inativo" name="active" value="INATIVA"--%>
<%--            <c:choose>--%>
<%--            <c:when test="${category.active() eq 'INATIVA'}">--%>
<%--                   checked--%>
<%--            </c:when>--%>
<%--            </c:choose>--%>
<%--            >--%>
<%--        </div>--%>

<%--        <div class="container-input-radio">--%>
<%--            <label for="ativo">Curso Ativo</label>--%>
<%--            <input type="radio" id="ativo" name="active" value="ATIVA"--%>
<%--            <c:choose>--%>
<%--            <c:when test="${category.active() eq 'ATIVA'}">--%>
<%--                   checked--%>
<%--            </c:when>--%>
<%--            </c:choose>--%>
<%--            >--%>
<%--        </div>--%>

<%--        <label for="order">Ordem</label>--%>
<%--        <input type="text" id="order" name="order" value="${category.order()}">--%>

<%--        <label for="icon">Url da Imagem</label>--%>
<%--        <input type="text" id="icon" name="iconPath" value="${category.iconPath()}" required>--%>

<%--        <label for="color">Cor em html</label>--%>
<%--        <input type="text" id="color" name="htmlColorCode" value="${category.htmlColorCode()}" required>--%>

<%--        <input id="submit" type="submit" value="Cadastrar">--%>

<%--    </form>--%>
<%--</main>--%>
<%--<footer>--%>
<%--    <p> Rui Nascimento</p>--%>
<%--    <div class="content-contact">--%>
<%--        <a href="https://github.com/sruinascimento" target="_blank">--%>
<%--            <i class="fa-brands fa-square-github"></i> Github--%>
<%--        </a>--%>
<%--        <a href="https://www.linkedin.com/in/sruinascimento/" target="_blank">--%>
<%--            <i class="fa-brands fa-linkedin"></i> Linkedin--%>
<%--        </a>--%>
<%--    </div>--%>
<%--</footer>--%>
<%--</body>--%>
<%--</html>--%>

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
