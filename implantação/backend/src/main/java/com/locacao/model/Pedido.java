package com.locacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	private String cpf_contratante;
	private String placa_veiculo;

	public Pedido() {
		super();
	}

	public Pedido(String cpf_contratante, String placa_veiculo) {
		super();
		this.cpf_contratante = cpf_contratante;
		this.placa_veiculo = placa_veiculo;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getCpf_contratante() {
		return cpf_contratante;
	}

	public void setCpf_contratante(String cpf_contratante) {
		this.cpf_contratante = cpf_contratante;
	}

	public String getPlaca_veiculo() {
		return placa_veiculo;
	}

	public void setPlaca_veiculo(String placa_veiculo) {
		this.placa_veiculo = placa_veiculo;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", cpf_contratante=" + cpf_contratante + ", placa_veiculo="
				+ placa_veiculo + "]";
	}

}
