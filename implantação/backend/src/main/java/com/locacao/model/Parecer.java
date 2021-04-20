package com.locacao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Parecer")
public class Parecer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_parecer;
	private int id_pedido;
	private String cnpj_agente;
	private Boolean aprovado;
	private Date data;

	public Parecer() {
		super();
	}

	public Parecer(int id_pedido, String cnpj_agente, Boolean aprovado, Date data) {
		super();
		this.id_pedido = id_pedido;
		this.cnpj_agente = cnpj_agente;
		this.aprovado = aprovado;
		this.data = data;
	}

	public int getId_parecer() {
		return id_parecer;
	}

	public void setId_parecer(int id_parecer) {
		this.id_parecer = id_parecer;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getCnpj_agente() {
		return cnpj_agente;
	}

	public void setCnpj_agente(String cnpj_agente) {
		this.cnpj_agente = cnpj_agente;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Parecer [id_parecer=" + id_parecer + ", id_pedido=" + id_pedido + ", cnpj_agente=" + cnpj_agente
				+ ", aprovado=" + aprovado + ", data=" + data + "]";
	}
}
