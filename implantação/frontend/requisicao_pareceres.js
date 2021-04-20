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

        response.forEach(element => {
            
            id_parecer = element.id_parecer;
            id_pedido = element.id_pedido;
            cnpj_agente = element.cnpj_agente;
            aprovado = element.marca;
            data = element.data;
            container = document.querySelector(".container3");
            template = 
            `
            <div class="central2">
                <strong>Id_parecer:&nbsp</strong>${id_parecer} <br/>
                <strong>Id_pedido:&nbsp</strong>${id_pedido} <br/>
                <strong>CNPJ_agente:&nbsp</strong>${cnpj_agente} <br/>
                <strong>Aprovado:&nbsp</strong>${aprovado} <br/>
                <strong>Data:&nbsp</strong>${data}<br/>
            </div>
            `
            container.innerHTML += template;
        
        });
    }
    


})