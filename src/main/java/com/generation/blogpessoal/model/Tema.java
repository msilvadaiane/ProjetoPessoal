package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="tb_tema")
public class Tema {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message="O atributo tema é obrigatório e nao pode conter espaco em branco")
	@Size (min=5, max=100, message= "O atributo título deve conter no mínimo 5 caracteres e no máximo 100")
	private String tema;
	

	@UpdateTimestamp 
	private LocalDateTime data;
	
	
public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


{

}
}
