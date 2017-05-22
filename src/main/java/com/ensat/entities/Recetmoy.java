package com.ensat.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author pankaj
 * 
 */
@Entity
@Table(name = "RECETMOY")
public class Recetmoy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "G4")
	@SequenceGenerator(name = "G4", sequenceName = "RECETMOY_SEQ")
	private int id;

	private String pays;
	
	private String destination;
	
	private String axe;
	
	private int annee;
	
	private int mois;
	
	private float recpaxmoy;
	
	private float recanexmoy;
	
	private String commentaires;

	//to complete
	@Override
	public String toString() {
		//to implement
		return "";
	}

	//to complete
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (!(o instanceof Recetmoy))
			return false;

		Recetmoy other = (Recetmoy) o;

		//to implement
		/*if (other.getId() == this.getId()
				&& Objects.equals(nom, other.getNom())) {
			return true;
		}*/
		return false;
	}

	//to complete
	@Override
	public int hashCode() {
		return Objects.hash(pays,destination,axe,annee,mois);
	}

}
