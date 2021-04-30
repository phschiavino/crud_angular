package com.produtos.crud.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	private int id;
	private String nome;
	private String desc;
	private int preco;
	
	public Produto() {
	}

	public Produto(int id, String nome, String desc, int preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.desc = desc;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

}
