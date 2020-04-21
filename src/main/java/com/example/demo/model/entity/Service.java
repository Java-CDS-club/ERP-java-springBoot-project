package com.example.demo.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //Touche Ctr+Espacement pour afficher les bibliothèques
@Table(name="Service") //cette annotation permet d'imposer le nom de l'entité afin que le logiciel ne choisisse pas un nom par défaut
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString  
public class Service implements Serializable{ // pour importer l'interface serializable. Ici on a rendu toute la classe sérializable.
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //pour indiquer lequel des attributs est l'Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //incrémentation automatique de l'identifiant
	@Column(name="CodeServ") //on indique le nom de l'attribut
	private Long id;
	@Column(name="LibServ")
	private String lib;
	
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Affecter> affecters;
	
	
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Employer> employers;
	
}
