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
            </div>
            `
            container.innerHTML += template;
        
        });
    }
})


