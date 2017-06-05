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

public class Rep3Form {

	
	@NotEmpty(message = "Ce champs ne peut pas etre vide !")
	private String S1;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String S2;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String S3;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String date1;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String date2;
	
	@NotEmpty(message = "Ce champs ne peut pas être vide !")
	private String date3;

	public String getS1() {
		return S1;
	}

	public void setS1(String s1) {
		S1 = s1;
	}

	public String getS2() {
		return S2;
	}

	public void setS2(String s2) {
		S2 = s2;
	}

	public String getS3() {
		return S3;
	}

	public void setS3(String s3) {
		S3 = s3;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getDate3() {
		return date3;
	}

	public void setDate3(String date3) {
		this.date3 = date3;
	}
	
}
