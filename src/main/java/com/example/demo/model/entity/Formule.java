package com.example.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //Touche Ctr+Espacement pour afficher les bibliothèques
@Table(name="Formule") //cette annotation permet d'imposer le nom de l'entité afin que le logiciel ne choisisse pas un nom par défaut
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString  
public class Formule implements Serializable{ // pour importer l'interface serializable. Ici on a rendu toute la classe sérializable.
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //pour indiquer lequel des attributs est l'Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //incrémentation automatique de l'identifiant
	@Column(name="CodeForm") //on indique le nom de l'attribut
	private Long id;
	@Column(name="LibForm")
	private String lib;
//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "formules")
//	private Set<Compte> comptes = new HashSet<>();
	
}
