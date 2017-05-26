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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * Elle est utilisée dans la creation des
 * formulaire pour saisi des informations pour générer rapport 2 
 * analyse des recettes par NTU
 * 
 * @author pankaj
 * 
 */

public class Rep2Form {

	@NotEmpty(message = "Ce champs ne peut pas etre vide !")
	private String NTU;
	
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
	@Pattern(regexp = "[0-9]+", message = "Ce champs est de type nombre !")
	private String Nvol11;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	@Pattern(regexp = "[0-9]+", message = "Ce champs est de type nombre !")
	private String Nvol12;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	@Pattern(regexp = "[0-9]+", message = "Ce champs est de type nombre !")
	private String Nvol21;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	@Pattern(regexp = "[0-9]+", message = "Ce champs est de type nombre !")
	private String Nvol22;

	public String getNTU() {
		return NTU;
	}

	public void setNTU(String nTU) {
		NTU = nTU;
	}

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

	public String getNvol11() {
		return Nvol11;
	}

	public void setNvol11(String nvol11) {
		Nvol11 = nvol11;
	}

	public String getNvol12() {
		return Nvol12;
	}

	public void setNvol12(String nvol12) {
		Nvol12 = nvol12;
	}

	public String getNvol21() {
		return Nvol21;
	}

	public void setNvol21(String nvol21) {
		Nvol21 = nvol21;
	}

	public String getNvol22() {
		return Nvol22;
	}

	public void setNvol22(String nvol22) {
		Nvol22 = nvol22;
	}
	
	
	
}
