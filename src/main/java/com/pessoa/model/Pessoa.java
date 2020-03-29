package com.pessoa.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="TBL_PESSOAS")
public class Pessoa {
	
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Long id;
     
     @Column(name="nome")
	 private String nome;
     
     @Column(name="rg")
	 private String rg; 
     
     @Column(name="cpf")
	 private String cpf;
     
     @Column(name="dtnascimento")
	 private String dtnascimento;
     
     @Column(name="fl_ativo", columnDefinition="BIT")
 	 private boolean ativo;	 


     @JsonManagedReference
	 @OneToMany(mappedBy = "pessoa",  cascade = CascadeType.ALL)
	 private List<Contato> contato;
	

}
