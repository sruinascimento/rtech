<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form | Categoria</title>
</head>
<body>
<header>

</header>
<main>
    <form action="/cadastraCategoria" method="post">
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
        <input type="submit" value="Cadastrar">

    </form>
</main>
<footer>

</footer>
</body>
</html>
