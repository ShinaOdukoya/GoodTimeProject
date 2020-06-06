package com.goodTime.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Client Data Transfer Object with accessors and mutators
*/
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID id;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="userName")
	@NotNull
	private String userName;
	
	@Column(name="businessName")
	private String businessName;
	
	@Column(name="emailAddress", unique=true, nullable=false)
	@Email
	@NotNull
	private String emailAddress;
	
	@Column(name = "phoneNumber")
	@NotNull
	private String phoneNumber;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "isBusinessOwner", columnDefinition = "TINYINT")
	private boolean isBusinessOwner;
	
	@Column(name = "isActivated", columnDefinition = "TINYINT")
	private boolean isActivated;
	
	@Column(name = "isAdmin", columnDefinition = "TINYINT")
	private boolean isAdmin;
	
	@Column(name= "lastLogin")
	private LocalDateTime lastLogIn;
		
	@CreationTimestamp
	@Column(name = "joinedAt")
	private LocalDateTime joinedAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "user",
			cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
	private List<Movie> movies;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ElementCollection
	private List<Role> roles;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean isBusinessOwner() {
		return isBusinessOwner;
	}

	public void setBusinessOwner(boolean isBusinessOwner) {
		this.isBusinessOwner = isBusinessOwner;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public LocalDateTime getLastLogIn() {
		return lastLogIn;
	}

	public void setLastLogIn(LocalDateTime lastLogIn) {
		this.lastLogIn = lastLogIn;
	}

	public LocalDateTime getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(LocalDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
		
	}
		
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
