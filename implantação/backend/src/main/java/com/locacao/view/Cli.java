package com.locacao.view;

import java.util.List;

public class Cli {
	
	@SuppressWarnings("unchecked")
	public static void imprimirLista (@SuppressWarnings("rawtypes") List lista) {
		lista.forEach(System.out::println);
	}

}
