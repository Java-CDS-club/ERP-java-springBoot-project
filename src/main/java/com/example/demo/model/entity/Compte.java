package com.example.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //Touche Ctr+Espacement pour afficher les bibliothèques
@Table(name="Compte") //cette annotation permet d'imposer le nom de l'entité afin que le logiciel ne choisisse pas un nom par défaut
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString  
public class Compte implements Serializable{ // pour importer l'interface serializable. Ici on a rendu toute la classe sérializable.
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //pour indiquer lequel des attributs est l'Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //incrémentation automatique de l'identifiant
	@Column(name="NumCpt") //on indique le nom de l'attribut
	private Long id;
	@Column(name="LibCpt")
	private String lib;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.PERSIST,
//                CascadeType.MERGE
//            })
//    @JoinTable(name = "Mouvement",
//            joinColumns = { @JoinColumn(name = "NumCpt") },
//            inverseJoinColumns = { @JoinColumn(name = "CodeForm") })
//    private Set<Formule> formules = new HashSet<>();
	
	@ManyToOne
    @JoinColumn
    private Client client;
	
	
	 @OneToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "CodeEmp", nullable = false)
	    private Employer employer;
}
