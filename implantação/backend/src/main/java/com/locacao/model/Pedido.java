package com.locacao.model;

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
@Table(name = "Pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CPF_Contratante")
	private Contratante contratante;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "Placa_veiculo")
	private Automovel automovel;
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "Id_Pedido")
	private Parecer parecer;

	public Pedido() {
		super();
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Parecer getParecer() {
		return parecer;
	}

	public void setParecer(Parecer parecer) {
		this.parecer = parecer;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", automovel=" + automovel + "]";
	}

}
