package com.locacao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Parecer")
public class Parecer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_parecer;
	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "Id_Pedido")
	private Pedido pedido;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "CNPJ_Agente")
	private Agente agente;
	private Boolean aprovado;
	private Date data;

	public Parecer() {
		super();
	}

	public Parecer(Pedido pedido, Agente agente, Boolean aprovado, Date data) {
		super();
		this.pedido = pedido;
		this.agente = agente;
		this.aprovado = aprovado;
		this.data = data;
	}

	public int getId_parecer() {
		return id_parecer;
	}

	public void setId_parecer(int id_parecer) {
		this.id_parecer = id_parecer;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	@Override
	public String toString() {
		return "Parecer [id_parecer=" + id_parecer + ", pedido=" + pedido + ", aprovado=" + aprovado + ", data=" + data
				+ ", agente=" + agente + "]";
	}

}
