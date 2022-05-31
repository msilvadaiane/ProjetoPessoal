package com.generation.blogpessoal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{

	public List<TemaModel> findAllByTemaContainingIgnoreCase(String tema);


}


