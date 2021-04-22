$(() => {

    $("#editar_pedido").on("submit", (e) => {
        e.preventDefault()

        id_pedido = $("#editar_pedido_id").val()
        cpf_contratante = $("#editar_pedido_cpf").val()
        placa_veiculo = $("#editar_pedido_placa").val()

        data = {
            id_pedido,
            cpf_contratante,
            placa_veiculo
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/modificar/pedido",
            data,
            success: () => {
                alert("Pedido modificado com sucesso")
                $("#editar_pedido_id").val("")
                $("#editar_pedido_cpf").val("")
                $("#editar_pedido_placa").val("")
            }
        })
    })

})