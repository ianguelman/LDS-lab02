package com.locacao.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@PostMapping("/cadastro/automovel")
	public void cadastrarAutomovel(@RequestParam() String placa, @RequestParam() String matricula,
			@RequestParam() int ano, @RequestParam() String marca, @RequestParam() String modelo) {
		automovelRepo.save(new Automovel(placa, matricula, ano, marca, modelo));
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@PostMapping("/cadastro/agente")
	public void cadastrarAgente(@RequestParam() String cnpj, @RequestParam() String empresa,
			@RequestParam() String login, @RequestParam() String senha, @RequestParam() String nome) {
		agenteRepo.save(new Agente(cnpj, empresa, login, senha, nome));
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@PostMapping("/cadastro/contratante")
	public void cadastrarContratante(@RequestParam() String cpf, @RequestParam() String rg,
			@RequestParam() String endereco, @RequestParam() String profissao,
			@RequestParam() String entidades_empregadoras, @RequestParam() float rendimento,
			@RequestParam() String login, @RequestParam() String senha, @RequestParam() String nome) {
		contratanteRepo.save(
				new Contratante(cpf, rg, endereco, profissao, entidades_empregadoras, rendimento, login, senha, nome));
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@PostMapping("/cadastro/parecer")
	public String cadastrarParecer(@RequestParam() int id_pedido, @RequestParam() String cnpj_agente,
			@RequestParam() Boolean aprovado, @RequestParam() @DateTimeFormat(pattern = "dd/MM/yyyy") Date data,
			@RequestParam() String placa_veiculo, @RequestParam(required = false) String cpf_contratante) {
		if (cpf_contratante != null) {
			automovelRepo.findById(placa_veiculo).get().setContratante(contratanteRepo.findById(cpf_contratante).get());
			automovelRepo.save(automovelRepo.findById(placa_veiculo).get());
		} else {
			automovelRepo.findById(placa_veiculo).get().setAgente(agenteRepo.findById(cnpj_agente).get());
			automovelRepo.save(automovelRepo.findById(placa_veiculo).get());
		}
		return parecerRepo.save(new Parecer(pedidoRepo.findById(id_pedido).get(),
				agenteRepo.findById(cnpj_agente).get(), aprovado, data)).toString();
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@PostMapping("/cadastro/pedido")
	public String cadastrarPedido(@RequestParam() String cpf_contratante, @RequestParam() String placa_veiculo) {
		return pedidoRepo.save(new Pedido(contratanteRepo.findById(cpf_contratante).get(),
				automovelRepo.findById(placa_veiculo).get())).toString();
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@GetMapping("/listar/automoveis")
	public List<Automovel> listarAutomoveis() {
		return automovelRepo.findAll();
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@GetMapping("/listar/agentes")
	public List<Agente> listarAgentes() {
		return agenteRepo.findAll();
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@GetMapping("/listar/contratantes")
	public List<Contratante> listarContratantes() {
		return contratanteRepo.findAll();
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@GetMapping("/listar/pareceres")
	public List<Parecer> listarPareceres() {
		return parecerRepo.findAll();
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@GetMapping("/listar/pedidos")
	public List<Pedido> listarPedidos() {
		return pedidoRepo.findAll();
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@PostMapping("/cancelar/pedido")
	public void cancelarPedido(@RequestParam() int id_pedido) {
		pedidoRepo.delete(pedidoRepo.findById(id_pedido).get());
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@PostMapping("/modificar/pedido")
	public void modificarPedido(@RequestParam() int id_pedido, @RequestParam() String placa_veiculo,
			@RequestParam() String cpf_contratante) {
		Pedido pedido = pedidoRepo.findById(id_pedido).get();
		pedido.setAutomovel(automovelRepo.findById(placa_veiculo).get());
		pedido.setContratante(contratanteRepo.findById(cpf_contratante).get());
		pedidoRepo.save(pedido);
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@PostMapping("/login/agente")
	public Agente logarAgente(@RequestParam() String cnpj, @RequestParam() String senha) {
		Optional<Agente> agente = agenteRepo.findById(cnpj);

		if (agente.isPresent()) {
			if (agente.get().getSenha().equals(senha))
				return agente.get();
			return null;
		}
		return null;
	}

	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://127.0.0.1:5500" })
	@PostMapping("/login/contratante")
	public Contratante logarContratante(@RequestParam() String cpf, @RequestParam() String senha) {
		Optional<Contratante> contratante = contratanteRepo.findById(cpf);

		if (contratante.isPresent()) {
			if (contratante.get().getSenha().equals(senha))
				return contratante.get();
			return null;
		}
		return null;
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
