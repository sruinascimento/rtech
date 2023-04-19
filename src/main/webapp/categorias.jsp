<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Categorias</title>
    <link rel="stylesheet" href="styles/reset.css">
    <link rel="stylesheet" href="styles/category-style.css">
    <script src="https://kit.fontawesome.com/34289682d8.js" crossorigin="anonymous"></script>
</head>
<body>
<header>
    <h1> RTech - Categorias</h1>
</header>
<main>

    <c:forEach items="${categories}" var="category">
    <section style="background-color: ${category.getHtmlColorCode()}">
        <img src="${category.getIconPath()}">
        <h3>${category.name}
        </h3>
        <p>${category.description}
        </p>
        <a href="/listaCategoria?id=${category.id}" class="atualizacao__dados">atualizar</a>
    </section>
    </c:forEach>
</main>

<footer>
    <p> Rui Nascimento</p>
    <div class="content-contact">
        <a href="https://github.com/sruinascimento" target="_blank">
            <i class="fa-brands fa-square-github"></i> Github
        </a>
        <a href="https://www.linkedin.com/in/sruinascimento/"  target="_blank">
            <i class="fa-brands fa-linkedin"></i> Linkedin
        </a>
    </div>
</footer>
</body>
</html>
