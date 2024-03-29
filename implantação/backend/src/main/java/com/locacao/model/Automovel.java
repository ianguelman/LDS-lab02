package com.locacao.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Automovel")
public class Automovel {
	@Id
	private String placa;
	private String matricula;
	private int ano;
	private String marca;
	private String modelo;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CPF_Contratante")
	private Contratante contratante;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CNPJ_Agente")
	private Agente agente;
	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "Placa_veiculo")
	private List<Pedido> pedidios;

	public Automovel() {
		super();
	}

	public Automovel(String placa, String matricula, int ano, String marca, String modelo) {
		super();
		this.placa = placa;
		this.matricula = matricula;
		this.ano = ano;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public List<Pedido> getPedidios() {
		return pedidios;
	}

	public void setPedidios(List<Pedido> pedidios) {
		this.pedidios = pedidios;
	}

	@Override
	public String toString() {
		return "Automovel [placa=" + placa + ", matricula=" + matricula + ", ano=" + ano + ", marca=" + marca
				+ ", modelo=" + modelo + "]";
	}

}
