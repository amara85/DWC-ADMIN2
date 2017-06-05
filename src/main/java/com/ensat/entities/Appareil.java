package com.ensat.entities;

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

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author pankaj
 * 
 */
@Entity
@Table(name = "DIM_APPAREIL")
@NamedQuery(name = "Appareil.findAll", query="select a from Appareil a order by a.id desc")
public class Appareil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "G5")
	@SequenceGenerator(name = "G5", sequenceName = "DIM_APPAREIL_SEQ")
	private int id;

	@List({
	    @Length(min = 1, message = "Ce champs ne peut pas etre vide !"),
	    @Length(max = 20, message = "La taille de username doit etre au maximum 20")
	})
	
	@Column(name = "code",unique=true)
	private String code;
	
	@Min(0)
	@Max(999)
	private int so;
	
	@List({
	    @Length(min = 1, message = "Ce champs ne peut pas etre vide !"),
	    @Length(max = 100, message = "La taille de username doit etre au maximum 100")
	})
	private String description;
	
	@List({
	    @Length(min = 1, message = "Ce champs ne peut pas etre vide !"),
	    @Length(max = 8, message = "La taille de username doit etre au maximum 8")
	})
	private String type;
	
	@List({
	    @Length(min = 1, message = "Ce champs ne peut pas etre vide !"),
	    @Length(max = 3, message = "La taille de username doit etre au maximum 3")
	})
	private String tuaff;
	
	@List({
	    @Length(min = 1, message = "Ce champs ne peut pas etre vide !"),
	    @Length(max = 20, message = "La taille de username doit etre au maximum 20")
	})
	private String famille;
	
	@Min(1)
	@Max(9)
	private Integer ordre;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSo() {
		return so;
	}

	public void setSo(int so) {
		this.so = so;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTuaff() {
		return tuaff;
	}

	public void setTuaff(String tuaff) {
		this.tuaff = tuaff;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	@Override
	public String toString() {
		return "id=" + id + ", code=" + code+ ", so=" + so+", description=" + description+", type=" + type + ", tuaff=" + tuaff;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (!(o instanceof Appareil))
			return false;

		Appareil other = (Appareil) o;

		if (other.getId() == this.getId()
				&& Objects.equals(code, other.getCode())
				&& Objects.equals(so, other.getSo())
				&& Objects.equals(description, other.getDescription())
				&& Objects.equals(type, other.getType())
				&& Objects.equals(tuaff, other.getTuaff())
				&& Objects.equals(famille, other.getFamille())
				&& Objects.equals(ordre, other.getOrdre())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

}
