$(() => {
    $("#login_agente").on("submit", (e) => {
        e.preventDefault()

        cnpj = $("#login_agente_cnpj").val()
        senha = $("#login_agente_senha").val()

        data = {
            cnpj,
            senha
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/login/agente",
            data,
            success: (response) => {
                console.log(response)
                if (response == "" )
                alert("Usuario ou senha invalidos")
                else {
                alert("Logado")
                $("#login_agente_cnpj").val("")
                $("#login_agente_senha").val("")
                localStorage.clear()
                localStorage.setItem("cnpj", cnpj)
                }
            }
        })
    })
})