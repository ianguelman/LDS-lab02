let tam;
let id = 1;
let container;
let template;

let id_pedido;
let cpf_contratante;
let placa_veiculo;

$(() => {
    // localStorage.setItem("cnpj", "16935239000193")

    window.aprovar = (id_pedido, aprovado, cpf_contratante, placa_veiculo) => {
        cnpj_agente = localStorage.getItem("cnpj")
        data = new Date(Date.now()).toLocaleDateString("pt-br", {
            year: "numeric",
            month: "2-digit",
            day: "2-digit",
        })
        if (cpf_contratante != 0)
            data = { id_pedido, cpf_contratante, aprovado, data, placa_veiculo, cnpj_agente }
        else data = { id_pedido, cnpj_agente, aprovado, data, placa_veiculo }
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/cadastro/parecer",
            data,
            success: () => {
                alert("Pedido analisado com sucesso")
            }
        })
    }

    window.cancelar = (id_pedido) => {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/cancelar/pedido",
            data: { id_pedido },
            success: () => {
                alert("Pedido cancelado com sucesso")
                location.reload()
            }
        })
    }

    $.ajax({
        url: "http://localhost:8080/listar/pedidos",
        dataType: 'json',
        success: function (response) {

            if (localStorage.getItem("cpf") != null) {

                response.filter(pedido => pedido.contratante.cpf == localStorage.getItem("cpf")).forEach(element => {

                    id_pedido = element.id_pedido;
                    cpf_contratante = element.contratante.cpf;
                    placa_veiculo = element.automovel.placa;
                    container = document.querySelector(".container3");
                    template =
                        `
                    <div class="central2">
                        <strong>Id_pedido:&nbsp</strong>${id_pedido} <br/>
                        <strong>CPF_contratante:&nbsp</strong>${cpf_contratante} <br/>
                        <strong>Placa_veiculo:&nbsp</strong>${placa_veiculo} <br/> 
                        <button type="button" onClick="cancelar('${id_pedido}')">Cancelar</button>    
                    </div>
                    `
                    container.innerHTML += template;

                });
            }

            else if (localStorage.getItem("cnpj") != null) {

                response.forEach(element => {

                    id_pedido = element.id_pedido;
                    cpf_contratante = element.contratante.cpf;
                    placa_veiculo = element.automovel.placa;
                    container = document.querySelector(".container3");
                    template =
                        `
                    <div class="central2">
                        <strong>Id_pedido:&nbsp</strong>${id_pedido} <br/>
                        <strong>CPF_contratante:&nbsp</strong>${cpf_contratante} <br/>
                        <strong>Placa_veiculo:&nbsp</strong>${placa_veiculo} <br/>
                        <button type="button" onClick="aprovar('${id_pedido}',true, 0, '${placa_veiculo}')">Aprovar (Agente)</button>
                        <button type="button" onClick="aprovar('${id_pedido}',true, '${cpf_contratante}', '${placa_veiculo}')">Aprovar (Cliente)</button>
                        <button type="button" onClick="aprovar('${id_pedido}',false)">Recusar</button>     
                    </div>
                    `
                    container.innerHTML += template;

                });
            }

        }



    })


})

