package com.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.Repository.TemaRepository;
import com.generation.blogpessoal.model.TemaModel;



@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
 private TemaRepository TemaRepository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll (){
		return ResponseEntity.ok(TemaRepository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <TemaModel> getById(@PathVariable Long id){
		return TemaRepository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity <TemaModel> postTema(@Valid @RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(TemaRepository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<TemaModel> putTema (@Valid @RequestBody TemaModel tema){
		return TemaRepository.findById(tema.getId())
			.map(resposta -> ResponseEntity.ok().body(TemaRepository.save(tema)))
			.orElse(ResponseEntity.notFound().build());
	
	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable long id) {
		return TemaRepository.findById(id)
				.map(resposta -> {
					TemaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}


