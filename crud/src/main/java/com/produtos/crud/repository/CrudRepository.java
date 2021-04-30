package com.produtos.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.crud.model.Produto;

public interface CrudRepository extends JpaRepository<Produto, Integer>{

}
