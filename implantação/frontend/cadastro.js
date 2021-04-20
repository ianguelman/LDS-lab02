$(() => {
    $("#cadastro_automovel").on("submit", (e) => {
        e.preventDefault()

        matricula = $("#cadastro_automovel_matricula").val()
        ano = $("#cadastro_automovel_ano").val()
        placa = $("#cadastro_automovel_placa").val()
        marca = $("#cadastro_automovel_marca").val()
        modelo = $("#cadastro_automovel_modelo").val()

        data = {
            matricula,
            ano,
            placa,
            marca,
            modelo
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/cadastro/automovel",
            data,
            success: () => {
                alert("Automovel cadastrado")
                $("#cadastro_automovel_matricula").val("")
                $("#cadastro_automovel_ano").val("")
                $("#cadastro_automovel_placa").val("")
                $("#cadastro_automovel_marca").val("")
                $("#cadastro_automovel_modelo").val("")
            }
        })
    })

    $("#cadastro_agente").on("submit", (e) => {
        e.preventDefault()

        nome = $("#cadastro_agente_nome").val()
        login = $("#cadastro_agente_login").val()
        senha = $("#cadastro_agente_senha").val()
        empresa = $("#cadastro_agente_empresa").val()
        cnpj = $("#cadastro_agente_cnpj").val()

        data = {
            nome,
            login,
            senha,
            empresa,
            cnpj
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/cadastro/agente",
            data,
            success: () => {
                alert("Agente cadastrado")
                $("#cadastro_agente_nome").val("")
                $("#cadastro_agente_login").val("")
                $("#cadastro_agente_senha").val("")
                $("#cadastro_agente_empresa").val("")
                $("#cadastro_agente_cnpj").val("")
            }
        })
    })

    $("#cadastro_contratante").on("submit", (e) => {
        e.preventDefault()

        nome = $("#cadastro_contratante_nome").val()
        login = $("#cadastro_contratante_login").val()
        senha = $("#cadastro_contratante_senha").val()
        rg = $("#cadastro_contratante_rg").val()
        cpf = $("#cadastro_contratante_cpf").val()
        endereco = $("#cadastro_contratante_endereco").val()
        profissao = $("#cadastro_contratante_profissao").val()
        entidades_empregadoras = $("#cadastro_contratante_entidades-empregadoras").val()
        rendimento = $("#cadastro_contratante_rendimentos").val()

        data = {
            nome,
            login,
            senha,
            rg,
            cpf,
            endereco,
            profissao,
            entidades_empregadoras,
            rendimento
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/cadastro/contratante",
            data,
            success: () => {
                alert("Contratante cadastrado")
                $("#cadastro_contratante_nome").val("")
                $("#cadastro_contratante_login").val("")
                $("#cadastro_contratante_senha").val("")
                $("#cadastro_contratante_rg").val("")
                $("#cadastro_contratante_cpf").val("")
                $("#cadastro_contratante_endereco").val("")
                $("#cadastro_contratante_profissao").val("")
                $("#cadastro_contratante_entidades-empregadoras").val("")
                $("#cadastro_contratante_rendimentos").val("")
            }
        })
    })
})
