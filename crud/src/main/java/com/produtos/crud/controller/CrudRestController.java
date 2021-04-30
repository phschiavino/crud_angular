package com.produtos.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.crud.model.Produto;
import com.produtos.crud.repository.CrudRepository;
import com.produtos.crud.services.CrudService;

@RestController
public class CrudRestController {
	
	@Autowired
	private CrudService service;
	
	@Autowired
	private CrudRepository repository;
	
	@GetMapping("/getProdutoLista")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Produto> listarProdutos(){
		List<Produto> produtos = new ArrayList<Produto>();
		produtos = service.listProdutos();
		return produtos;
	}
	
	@PostMapping("/insereProdutoLista")
	@CrossOrigin(origins = "http://localhost:4200")
	public Produto inserirProdutos(@RequestBody Produto produto){
		return service.insereProdutoBD(produto);
	}
	
	@GetMapping("/getProdutoID/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Produto buscaProduto(@PathVariable int id){
		return service.buscaProdutoID(id).get();
	}
	
	@PutMapping("/putProdutoID/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Produto> updateProduto(@PathVariable("id") int id, @RequestBody Produto produto) {
		Optional<Produto> produtoData = repository.findById(id);

		if (produtoData.isPresent()) {
			Produto _produto = produtoData.get();
			_produto.setId(produto.getId());
			_produto.setNome(produto.getNome());
			_produto.setDesc(produto.getDesc());
			_produto.setPreco(produto.getPreco());
			return new ResponseEntity<>(repository.save(_produto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@DeleteMapping("/getDeletaProdutoID/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deletaProdutoID(@PathVariable int id){
		return service.removeProdutoBD(id);
	}
}
