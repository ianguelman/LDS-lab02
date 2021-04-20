let tam;
let id = 1;
let container;
let template;

let placa;
let matricula;
let ano;
let marca;
let modelo;

$.ajax({
    url: "http://localhost:8080/listar/automoveis/",
    dataType: 'json',
    success: function (response) {

        tam = response.length;

        while (id <= tam) {
            $.ajax({
                url: "http://localhost:8080/listar/automoveis/" + id,
                dataType: 'json',
                success: function (response2) {
                    placa = response2.placa;
                    matricula = response2.matricula;
                    ano = response2.ano;
                    marca = response2.marca;
                    modelo = response2.modelo;
                    container = document.querySelector(".container3");
                    template = 
                    `
                    <div class="central2">
                        <strong>Placa:&nbsp</strong>${placa} <br/>
                        <strong>Matricula:&nbsp</strong>${matricula} <br/>
                        <strong>Ano:&nbsp</strong>${ano} <br/>
                        <strong>marca:&nbsp</strong>${marca} <br/>
                        <strong>Modelo:&nbsp</strong>${modelo}<br/>
                    </div>
                    `
                    container.innerHTML += template;
                }
            });
            ++id;
        }

    }
});


