let tam;
let id = 1;
let container;
let template;

let id_pedido;
let cpf_contratante;
let placa_veiculo;

$.ajax({
    url: "http://localhost:8080/listar/pedidos/",
    dataType: 'json',
    success: function (response) {

        tam = response.length;

        while (id <= tam) {
            $.ajax({
                url: "http://localhost:8080/listar/pedidos/" + id,
                dataType: 'json',
                success: function (response2) {
                    id_pedido = response2.id_pedido;
                    cpf_contratante = response2.cpf_contratante;
                    placa_veiculo = response2.placa_veiculo;
                    container = document.querySelector(".container3");
                    template = 
                    `
                    <div class="central2">
                        <strong>Id_pedido:&nbsp</strong>${id_pedido} <br/>
                        <strong>CPF_contratante:&nbsp</strong>${cpf_contratante} <br/>
                        <strong>Placa_veiculo:&nbsp</strong>${placa_veiculo} <br/>
                    </div>
                    `
                    container.innerHTML += template;
                }
            });
            ++id;
        }

    }
});


