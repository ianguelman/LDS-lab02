package com.locacao.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.locacao.model.Agente;
import com.locacao.model.AgenteRepository;
import com.locacao.model.Automovel;
import com.locacao.model.AutomovelRepository;
import com.locacao.model.Contratante;
import com.locacao.model.ContratanteRepository;
import com.locacao.model.Parecer;
import com.locacao.model.ParecerRepository;
import com.locacao.model.Pedido;
import com.locacao.model.PedidoRepository;
import com.locacao.view.Cli;

@SpringBootApplication
@RestController
@EnableJpaRepositories("com.locacao.model")
@EntityScan("com.locacao.model")
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private AutomovelRepository automovelRepo;

	@Autowired
	private AgenteRepository agenteRepo;

	@Autowired
	private ContratanteRepository contratanteRepo;

	@Autowired
	private ParecerRepository parecerRepo;

	@Autowired
	private PedidoRepository pedidoRepo;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/cadastro/automovel")
	public String cadastrarAutomovel(@RequestParam() String placa, @RequestParam() String matricula,
			@RequestParam() int ano, @RequestParam() String marca, @RequestParam() String modelo) {
		return automovelRepo.save(new Automovel(placa, matricula, ano, marca, modelo)).toString();
	}

	@GetMapping("/cadastro/agente")
	public String cadastrarAgente(@RequestParam() String cnpj, @RequestParam() String empresa,
			@RequestParam() String login, @RequestParam() String senha, @RequestParam() String nome,
			@RequestParam(required=false) String placa_veiculo) {
		return agenteRepo.save(new Agente(cnpj, empresa, login, senha, nome, placa_veiculo)).toString();
	}

	@GetMapping("/cadastro/contratante")
	public String cadastrarContratante(@RequestParam() String cpf, @RequestParam() String rg,
			@RequestParam() String endereco, @RequestParam() String profissao,
			@RequestParam() String entidades_empregadoras, @RequestParam() float rendimento,
			@RequestParam() String login, @RequestParam() String senha, @RequestParam() String nome,
			@RequestParam(required = false) String placa_veiculo) {
		return contratanteRepo.save(new Contratante(cpf, rg, endereco, profissao, entidades_empregadoras, rendimento,
				login, senha, nome, placa_veiculo)).toString();
	}
	
	@GetMapping("/cadastro/parecer")
	public String cadastrarParecer(@RequestParam() int id_pedido, @RequestParam() String cnpj_agente,
			@RequestParam() Boolean aprovado, @RequestParam() @DateTimeFormat(pattern = "dd.MM.yyyy")Date data) {
		return parecerRepo.save(new Parecer(id_pedido, cnpj_agente, aprovado, data)).toString();
	}
	
	@GetMapping("/cadastro/pedido")
	public String cadastrarPedido(@RequestParam() String cpf_contratante,
			@RequestParam() String placa_veiculo) {
		return pedidoRepo.save(new Pedido(cpf_contratante, placa_veiculo)).toString();
	}
	
	@GetMapping("/listar/automoveis")
	public List<Automovel> listarAutomoveis() {
		return automovelRepo.findAll();
	}

	@GetMapping("/listar/agentes")
	public List<Agente> listarAgentes() {
		return agenteRepo.findAll();
	}

	@GetMapping("/listar/contratantes")
	public List<Contratante> listarContratantes() {
		return contratanteRepo.findAll();
	}

	@GetMapping("/listar/pareceres")
	public List<Parecer> listarPareceres() {
		return parecerRepo.findAll();
	}
	
	@GetMapping("/listar/pedidos")
	public List<Pedido> listarPedidos() {
		return pedidoRepo.findAll();
	}

	@Override
	public void run(String... args) throws Exception {

		List<Automovel> automoveis = automovelRepo.findAll();
		Cli.imprimirLista(automoveis);

		List<Agente> agentes = agenteRepo.findAll();
		Cli.imprimirLista(agentes);

		List<Contratante> contratantes = contratanteRepo.findAll();
		Cli.imprimirLista(contratantes);

		List<Parecer> pareceres = parecerRepo.findAll();
		Cli.imprimirLista(pareceres);

		List<Pedido> pedidos = pedidoRepo.findAll();
		Cli.imprimirLista(pedidos);
	}

}
