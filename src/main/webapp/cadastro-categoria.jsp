<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form | Categoria</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/reset.css">
    <link rel="stylesheet" href="styles/cadastro.css">

</head>
<body>
<header>
    <h1> RTech - Cadastro </h1>
</header>
<main>
    <form class="form" action="/cadastraCategoria" method="post">
        <label for="name">Nome da Categoria</label>
        <input type="text" id="name" name="name" required>
        <label for="code">Código</label>
        <input type="text" id="code" name="code" required>
        <label for="color">Cor em html</label>
        <input type="text" id="color" name="color" required>
        <label for="icon">Url da Imagem</label>
        <input type="text" id="icon" name="icon" required>
        <label for="description">Descrição</label>
        <textarea name="description" id="description" required>

        </textarea>
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
