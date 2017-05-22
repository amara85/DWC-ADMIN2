package com.ensat.entities;

import java.util.Date;
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

import oracle.sql.DATE;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author pankaj
 * 
 */
@Entity
@Table(name = "DIM_TEMPS")
public class Dimtemps {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "G3")
	@SequenceGenerator(name = "G3", sequenceName = "DIM_TEMPS_SEQ")
	private int id;

	private int annee;
	
	private int mois;
	
	private Date datev;
	
	private int jo;
	
	private int sem_sai;
	
	private String saison;
	
	private String annee_av;
	
	private int sem_ann_av;
	
	private int jod;
	
	private int id_action;
	
	private String periode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public Date getDatev() {
		return datev;
	}

	public void setDatev(Date datev) {
		this.datev = datev;
	}

	public int getJo() {
		return jo;
	}

	public void setJo(int jo) {
		this.jo = jo;
	}

	public int getSem_sai() {
		return sem_sai;
	}

	public void setSem_sai(int sem_sai) {
		this.sem_sai = sem_sai;
	}

	public String getSaison() {
		return saison;
	}

	public void setSaison(String saison) {
		this.saison = saison;
	}

	public String getAnnee_av() {
		return annee_av;
	}

	public void setAnnee_av(String annee_av) {
		this.annee_av = annee_av;
	}

	public int getSem_ann_av() {
		return sem_ann_av;
	}

	public void setSem_ann_av(int sem_ann_av) {
		this.sem_ann_av = sem_ann_av;
	}

	public int getJod() {
		return jod;
	}

	public void setJod(int jod) {
		this.jod = jod;
	}

	public int getId_action() {
		return id_action;
	}

	public void setId_action(int id_action) {
		this.id_action = id_action;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

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

		if (!(o instanceof Dimtemps))
			return false;

		Dimtemps other = (Dimtemps) o;

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
		return Objects.hash(annee, mois, datev.getDate());
	}

}
