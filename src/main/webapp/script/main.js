var botoes = document.querySelectorAll("#button_status");

const ACTIVE_CATEGORY = "ATIVA";
const INACTIVE_CATEGORY = "INATIVA";


botoes.forEach(botao => {

    if (ACTIVE_CATEGORY === botao.textContent.toUpperCase().trim()) {
        botao.classList.add("categoria_ativa");
    }
    if (INACTIVE_CATEGORY === botao.textContent.toUpperCase().trim()) {
        botao.classList.add("categoria_inativa");
    }
});

botoes.forEach(botao => {
    botao.addEventListener("click", event => {
        var xhr = new XMLHttpRequest();
        var id = getIdCategory(botao);
        var status = getStatusCategory(botao);
        var url = "http://localhost:8080/alteraStatusCategoria";
        // var url = `http://localhost:8080/alteraStatusCategoria?${createPartfUrl(id, status)}`;
        console.log(url)
        var requestBody = formatParams(id, status);

        xhr.open("POST", url);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xhr.addEventListener("load", () => {
            if (xhr.status == 200) {
                var status = toggleCategoryStatus(botao.textContent);
                botao.textContent = status;
            } else {
                console.log(xhr.status);
                console.log(xhr.responseText);
            }
        });

        xhr.send(requestBody);

    });
})

function getStatusCategory(button) {
    return button.textContent.trim().toUpperCase();
}

function getIdCategory(button) {
    return button.parentNode.querySelector("h4").textContent;
}

function createRequestBody(id, status) {
    return {
        id: parseInt(id.trim().substring(id.length-1)),
        status: status
    }
}

function formatParams(id, status) {
    return `id=${id.substring(id.length-1)}&status=${status}`.trim();
}

function toggleCategoryStatus(status) {
    if (ACTIVE_CATEGORY === status.trim())  return INACTIVE_CATEGORY;
    if (INACTIVE_CATEGORY === status.trim())  return ACTIVE_CATEGORY;
}

