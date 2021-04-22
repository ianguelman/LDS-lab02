let tam;
let id = 1;
let container;
let template;

let placa;
let matricula;
let ano;
let marca;
let modelo;

$(() => {
    localStorage.setItem("cpf","69637888047")

    window.alugar = (placa_veiculo) => {
        cpf_contratante = localStorage.getItem("cpf")
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/cadastro/pedido",
            data: {cpf_contratante, placa_veiculo},
            success: () => {
                alert("Pedido de aluguel realizado")
            }
        })
    }

    $.ajax({
        url: "http://localhost:8080/listar/automoveis/",
        dataType: 'json',
        success: function (response) {

            response.forEach(element => {

                placa = element.placa;
                matricula = element.matricula;
                ano = element.ano;
                marca = element.marca;
                modelo = element.modelo;
                container = document.querySelector(".container3");
                template =
                    `
            <div class="central2">
                <strong>Placa:&nbsp</strong>${placa} <br/>
                <strong>Matricula:&nbsp</strong>${matricula} <br/>
                <strong>Ano:&nbsp</strong>${ano} <br/>
                <strong>marca:&nbsp</strong>${marca} <br/>
                <strong>Modelo:&nbsp</strong>${modelo}<br/>
                <button type="button" onClick="alugar('${placa}')">Alugar</button>
            </div>
            `
                container.innerHTML += template;

            });
        }
    })

})

