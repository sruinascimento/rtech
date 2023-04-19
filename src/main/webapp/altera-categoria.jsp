<html>
<head>
    <title>Form | Categoria</title>
</head>
<body>
<header>

</header>
<main>
    <form action="/alteraCategoria" method="post">
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

        <input type="submit" value="Cadastrar">
    </form>
</main>
<footer>

</footer>
</body>
</html>
