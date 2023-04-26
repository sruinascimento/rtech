<html>
<head>
    <title>Form | Categoria</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/reset.css">
    <link rel="stylesheet" href="styles/cadastro.css">
</head>
<body>
<header>
    <h1> RTech - Atualização</h1>
</header>
<main>
    <form class="form" action="/alteraCategoria" method="post">
        <label for="name">Nome da Categoria</label>
        <input type="text" id="name" name="name" value="${category.name}" required>

        <label for="code">Código</label>
        <input type="text" id="code" name="code" value="${category.id}" hidden="hidden" required>

        <label for="color">Cor em html</label>
        <input type="text" id="color" name="color" value="${category.htmlColorCode}" required>

        <label for="icon">Url da Imagem</label>
        <input type="text" id="icon" name="icon" value="${category.iconPath}" required>

        <label for="description">Descrição</label>
        <input type="text" name="description" id="description" value="${category.description}" required>

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
