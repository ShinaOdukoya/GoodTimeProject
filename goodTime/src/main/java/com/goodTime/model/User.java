package com.goodTime.model;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Client Data Transfer Object with accessors and mutators
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	@NotNull
	private String name;

	private String imageUrl;

	@NotNull
	@Enumerated(EnumType.STRING)
	private AuthProvider provider;

	@Column(name = "userName")
	private String userName;

	@Column(name = "businessName")
	private String businessName;

	@Column(name = "emailAddress", unique = true, nullable = false)
	@Email
	@NotNull
	private String emailAddress;

	@Column(name = "phoneNumber")
//	@NotNull
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

	@Column(name = "lastLogin")
	private LocalDateTime lastLogIn;

	@CreationTimestamp
	@Column(name = "joinedAt")
	private LocalDateTime joinedAt;

	private String providerId;

	@UpdateTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;

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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
