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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="USERS")
public class User {

	@Id
	private String username;
	
	private String password;
	
	private String prenom;
	
	private String nom;
	
	private boolean enabled;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USERNAME"),
            inverseJoinColumns = @JoinColumn(name = "ID_ROLE")
    )
	private Set<Role> roles = new HashSet<Role>(0);
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString(){
		return "username="+username+", prenom="+prenom+", nom="+nom+", enabled="+enabled;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o == this) return true;

		if (!(o instanceof Role))
			return false;

		User other = (User) o;

		if (Objects.equals(username, other.getUsername()) 
				&& Objects.equals(nom, other.getNom()) 
				&& Objects.equals(prenom, other.getPrenom()) 
				&& Objects.equals(password, other.getPassword()) 
				&& other.isEnabled() == (this.isEnabled()) ) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}
}
