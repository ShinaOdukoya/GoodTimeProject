package com.goodTime.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MovieCategory")
public class MovieCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name= "name")
	@NotNull
	private String name;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	@CreationTimestamp
	@Column(name = "createdAt")
	private LocalDateTime dateCreated;
	
	@ManyToMany
	@JoinTable(
			name = "movies_category",
			joinColumns =@JoinColumn(name ="movieCategory_id"),
			inverseJoinColumns =@JoinColumn(name = "movie_id")
			)
	private List<Movie> movies;

	

}
