let tam;
let id = 1;
let container;
let template;

let id_parecer;
let id_pedido;
let cnpj_agente;
let aprovado;
let data;

$.ajax({
    url: "http://localhost:8080/listar/pareceres/",
    dataType: 'json',
    success: function (response) {
        if (localStorage.getItem("cpf") != null) {

            response.filter(parecer => parecer.pedido.contratante.cpf == localStorage.getItem("cpf")).forEach(element => {

                id_parecer = element.id_parecer;
                id_pedido = element.pedido.id_pedido;
                cnpj_agente = element.agente.cnpj;
                aprovado = element.aprovado;
                placa_veiculo = element.pedido.automovel.placa
                data = element.data;
                container = document.querySelector(".container3");
                template =
                    `
            <div class="central2">
                <strong>Id_parecer:&nbsp</strong>${id_parecer} <br/>
                <strong>Id_pedido:&nbsp</strong>${id_pedido} <br/>
                <strong>Placa veiculo:&nbsp</strong>${placa_veiculo} <br/>
                <strong>CNPJ_agente:&nbsp</strong>${cnpj_agente} <br/>
                <strong>Aprovado:&nbsp</strong>${aprovado} <br/>
                <strong>Data:&nbsp</strong>${new Date(data).toLocaleDateString("pt-br", {
                        year: "numeric",
                        month: "2-digit",
                        day: "2-digit"})}<br/>
            </div>
            `
                container.innerHTML += template;

            })
        }

        else if (localStorage.getItem("cnpj") != null) {

            response.forEach(element => {

                id_parecer = element.id_parecer;
                id_pedido = element.pedido.id_pedido;
                cnpj_agente = element.agente.cnpj;
                aprovado = element.aprovado;
                placa_veiculo = element.pedido.automovel.placa
                data = element.data;
                container = document.querySelector(".container3");
                template =
                    `
            <div class="central2">
                <strong>Id_parecer:&nbsp</strong>${id_parecer} <br/>
                <strong>Id_pedido:&nbsp</strong>${id_pedido} <br/>
                <strong>Placa veiculo:&nbsp</strong>${placa_veiculo} <br/>
                <strong>CNPJ_agente:&nbsp</strong>${cnpj_agente} <br/>
                <strong>Aprovado:&nbsp</strong>${aprovado} <br/>
                <strong>Data:&nbsp</strong>${new Date(data).toLocaleDateString("pt-br", {
                        year: "numeric",
                        month: "2-digit",
                        day: "2-digit"})}<br/>
            </div>
            `
                container.innerHTML += template;

            })
        }
    
    }

})