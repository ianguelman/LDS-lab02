package com.locacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
