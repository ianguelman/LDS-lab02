package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
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
		automoveis.forEach(System.out::println);

		List<Agente> agentes = agenteRepo.findAll();
		agentes.forEach(System.out::println);

		List<Contratante> contratantes = contratanteRepo.findAll();
		contratantes.forEach(System.out::println);

		List<Parecer> pareceres = parecerRepo.findAll();
		pareceres.forEach(System.out::println);

		List<Pedido> pedidos = pedidoRepo.findAll();
		pedidos.forEach(System.out::println);
	}

}
