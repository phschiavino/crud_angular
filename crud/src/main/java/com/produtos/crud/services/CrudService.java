package com.produtos.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.crud.model.Produto;
import com.produtos.crud.repository.CrudRepository;

@Service
public class CrudService {
	
	@Autowired
	private CrudRepository repository;
	
	public List<Produto> listProdutos(){
		return repository.findAll();
	}
	
	public Produto insereProdutoBD(Produto produto) {
		return repository.save(produto);
	}
	
	public Optional<Produto> buscaProdutoID(int id) {
		return repository.findById(id);
	}

	public String removeProdutoBD(int id) {
		String resultado;
		try {
			repository.deleteById(id);
			resultado = "Produto removido";
		} catch (Exception e) {
			resultado = "Erro ao remover";
		}
		return resultado;
	}

}
