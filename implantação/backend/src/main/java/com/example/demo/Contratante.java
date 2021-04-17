package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String placa_veiculo;

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

	public String getPlaca_veiculo() {
		return placa_veiculo;
	}

	public void setPlaca_veiculo(String placa_veiculo) {
		this.placa_veiculo = placa_veiculo;
	}

	@Override
	public String toString() {
		return "Contratante [cpf=" + cpf + ", rg=" + rg + ", endereco=" + endereco + ", profissao=" + profissao
				+ ", entidades_empregadoras=" + entidades_empregadoras + ", rendimento=" + rendimento + ", login="
				+ login + ", senha=" + senha + ", nome=" + nome + ", placa_veiculo=" + placa_veiculo + "]";
	}
}
