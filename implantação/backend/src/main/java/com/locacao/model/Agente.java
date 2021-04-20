package com.locacao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Agente")
public class Agente {
	@Id
	private String cnpj;
	private String empresa;
	private String login;
	private String senha;
	private String nome;
	private String placa_veiculo;

	public Agente() {
		super();
	}

	public Agente(String cnpj, String empresa, String login, String senha, String nome, String placa_veiculo) {
		super();
		this.cnpj = cnpj;
		this.empresa = empresa;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.placa_veiculo = placa_veiculo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca_veiculo() {
		return placa_veiculo;
	}

	public void setPlaca_veiculo(String placa_veiculo) {
		this.placa_veiculo = placa_veiculo;
	}

	@Override
	public String toString() {
		return "Agente [cnpj=" + cnpj + ", empresa=" + empresa + ", login=" + login + ", senha=" + senha + ", nome="
				+ nome + ", placa_veiculo=" + placa_veiculo + "]";
	}

}
