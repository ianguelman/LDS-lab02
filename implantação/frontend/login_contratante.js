$(() => {
    $("#login_contratante").on("submit", (e) => {
        e.preventDefault()

        cpf = $("#login_contratante_cpf").val()
        senha = $("#login_contratante_senha").val()

        data = {
            cpf,
            senha
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/login/contratante",
            data,
            success: (response) => {
                console.log(response)
                if (response == "" )
                alert("Usuario ou senha invalidos")
                else {
                alert("Logado")
                $("#login_contratante_cpf").val("")
                $("#login_contratante_senha").val("")
                localStorage.clear()
                localStorage.setItem("cpf", cpf)
                }
            }
        })
    })
})