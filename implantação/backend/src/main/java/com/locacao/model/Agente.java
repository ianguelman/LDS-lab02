package com.locacao.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Agente")
public class Agente {
	@Id
	private String cnpj;
	private String empresa;
	private String login;
	private String senha;
	private String nome;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CNPJ_Agente")
	private List<Automovel> automoveis;
	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CNPJ_Agente")
	private Set<Parecer> pareceres;

	public Agente() {
		super();
	}

	public Agente(String cnpj, String empresa, String login, String senha, String nome) {
		super();
		this.cnpj = cnpj;
		this.empresa = empresa;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
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

	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	public Set<Parecer> getPareceres() {
		return pareceres;
	}

	public void setPareceres(Set<Parecer> pareceres) {
		this.pareceres = pareceres;
	}

	@Override
	public String toString() {
		return "Agente [cnpj=" + cnpj + ", empresa=" + empresa + ", login=" + login + ", senha=" + senha + ", nome="
				+ nome + ", automoveis=" + automoveis + "]";
	}

}
