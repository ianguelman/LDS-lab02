package com.locacao.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Contratante")
public class Contratante {
	@Id
	private String cpf;
	private String rg;
	private String endereco;
	private String profissao;
	private String entidades_empregadoras;
	private float rendimento;
	private String login;
	private String senha;
	private String nome;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CPF_Contratante")
	private List<Automovel> automoveis;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CPF_Contratante")
	private Set<Pedido> pedidos;

	public Contratante() {
		super();
	}

	public Contratante(String cpf, String rg, String endereco, String profissao, String entidades_empregadoras,
			float rendimento, String login, String senha, String nome) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.profissao = profissao;
		this.entidades_empregadoras = entidades_empregadoras;
		this.rendimento = rendimento;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEntidades_empregadoras() {
		return entidades_empregadoras;
	}

	public void setEntidades_empregadoras(String entidades_empregadoras) {
		this.entidades_empregadoras = entidades_empregadoras;
	}

	public float getRendimento() {
		return rendimento;
	}

	public void setRendimento(float rendimento) {
		this.rendimento = rendimento;
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

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Contratante [cpf=" + cpf + ", rg=" + rg + ", endereco=" + endereco + ", profissao=" + profissao
				+ ", entidades_empregadoras=" + entidades_empregadoras + ", rendimento=" + rendimento + ", login="
				+ login + ", senha=" + senha + ", nome=" + nome + ", automoveis=" + automoveis + ", pedidos=" + pedidos
				+ "]";
	}


}
