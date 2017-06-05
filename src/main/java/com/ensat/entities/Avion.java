package com.ensat.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Length.List;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * 
 */
@Entity
@Table(name = "DIM_AVION")
@NamedQuery(name = "Avion.findAll", query="select a from Avion a order by a.id desc")
public class Avion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "G6")
	@SequenceGenerator(name = "G6", sequenceName = "DIM_Avion_SEQ")
	private int id;

	@List({
	    @Length(min = 1, message = "Ce champs ne peut pas etre vide !"),
	    @Length(max = 8, message = "La taille de username doit etre au maximum 8")
	})
	
	@Column(name = "imm",unique=true)
	private String imm;
	
	private String appareil;
	
	private Integer capacite;
	
	private String tuaff;
	
	private String cowner;
	
	private String nowner;
	
	private String type;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dentree;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dsortie;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImm() {
		return imm;
	}

	public void setImm(String imm) {
		this.imm = imm;
	}

	public String getAppareil() {
		return appareil;
	}

	public void setAppareil(String appareil) {
		this.appareil = appareil;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public String getTuaff() {
		return tuaff;
	}

	public void setTuaff(String tuaff) {
		this.tuaff = tuaff;
	}

	public String getCowner() {
		return cowner;
	}

	public void setCowner(String cowner) {
		this.cowner = cowner;
	}

	public String getNowner() {
		return nowner;
	}

	public void setNowner(String nowner) {
		this.nowner = nowner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDentree() {
		return dentree;
	}

	public void setDentree(Date dentree) {
		this.dentree = dentree;
	}

	public Date getDsortie() {
		return dsortie;
	}

	public void setDsortie(Date dsortie) {
		this.dsortie = dsortie;
	}

	@Override
	public String toString() {
		return "id=" + id + ", imm=" + imm + ", appareil=" + appareil+", capacite=" + capacite+", tuaff=" + tuaff + ", cowner=" + cowner + ", nowner=" + nowner + ", type=" + type + ", dentree=" + dentree + ", dsortie=" + dsortie;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (!(o instanceof Avion))
			return false;

		Avion other = (Avion) o;

		if (other.getId() == this.getId()
				&& Objects.equals(imm, other.getImm())
				&& Objects.equals(appareil, other.getAppareil())
				&& Objects.equals(capacite, other.getCapacite())
				&& Objects.equals(tuaff, other.getTuaff())
				&& Objects.equals(cowner, other.getCowner())
				&& Objects.equals(nowner, other.getNowner())
				&& Objects.equals(type, other.getType())
				&& Objects.equals(dentree, other.getDentree())
				&& Objects.equals(dsortie, other.getDsortie())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(imm);
	}

}
