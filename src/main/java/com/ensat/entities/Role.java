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
@Table(name = "ROLES")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "G2")
	@SequenceGenerator(name = "G2", sequenceName = "ROLES_SEQ")
	private int id;

	private String nom;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<User> users = new HashSet<User>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nom=" + nom;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (!(o instanceof Role))
			return false;

		Role other = (Role) o;

		if (other.getId() == this.getId()
				&& Objects.equals(nom, other.getNom())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

}
