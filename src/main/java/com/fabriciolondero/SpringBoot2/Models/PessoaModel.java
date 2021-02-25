package com.fabriciolondero.SpringBoot2.Models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PessoaModel 
{
	public PessoaModel(String nome, Integer idade)
	{
		this.nome = nome;
		this.idade = idade;
	}
	
	@NotNull
	@Size(min=2, max=30)
	private String nome;

	@NotNull
	@Min(18)
	private Integer idade;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String toString() {
		return "Pessoa (Nome: " + this.nome+ ", Idade: " + this.idade + ")";
	}
}
