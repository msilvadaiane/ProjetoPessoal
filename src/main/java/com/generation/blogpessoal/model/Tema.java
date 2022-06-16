package com.generation.blogpessoal.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tb_tema")
public class Tema {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message="O atributo tema é obrigatório e nao pode conter espaco em branco")
	@Size (min=5, max=100, message= "O atributo título deve conter no mínimo 5 caracteres e no máximo 100")
	private String tema;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;
	
	
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
	
	public List<Postagem> getPostagem()
	{
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem)
	{
		this.postagem = postagem;


	


}
}
