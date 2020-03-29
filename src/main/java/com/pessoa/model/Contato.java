package com.pessoa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
@Entity
@Table(name="TBL_CONTATO")
public class Contato {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	 
	 @Column(name="nome")
	 private String nome;
	 
	 @Column(name="telefone")
	 private String telefone; 
	 
	 @Column(name="celular")
	 private String celular; 	
	 
     @Column(name="fl_ativo", columnDefinition="BIT")
 	 private boolean ativo;	 
	 

	 @JsonBackReference
	 @ManyToOne
	 @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	 private Pessoa pessoa;


}
