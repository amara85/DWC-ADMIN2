package com.ensat.forms.reports;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Elle est utilisée dans la creation des
 * formulaire pour saisi des informations pour générer rapport 1 
 * analyse des recettes par destination
 * 
 */

public class Rep1Form {

	@NotEmpty(message = "Ce champs ne peut pas etre vide !")
	private String P1;
	
	@NotEmpty(message = "Ce champs ne peut pas etre vide !")
	private String P2;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String date11;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String date12;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String date21;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String date22;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String destination;
	
	public String getP1() {
		return P1;
	}
	public void setP1(String p1) {
		P1 = p1;
	}
	public String getP2() {
		return P2;
	}
	public void setP2(String p2) {
		P2 = p2;
	}
	public String getDate11() {
		return date11;
	}
	public void setDate11(String date11) {
		this.date11 = date11;
	}
	public String getDate12() {
		return date12;
	}
	public void setDate12(String date12) {
		this.date12 = date12;
	}
	public String getDate21() {
		return date21;
	}
	public void setDate21(String date21) {
		this.date21 = date21;
	}
	public String getDate22() {
		return date22;
	}
	public void setDate22(String date22) {
		this.date22 = date22;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
