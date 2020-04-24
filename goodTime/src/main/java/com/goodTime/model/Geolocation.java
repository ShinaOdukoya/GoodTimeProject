package com.goodTime.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="geolocations")
public class Geolocation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="latitude")
	@NotNull
	private String latitude;
		
	@Column(name="longitude")
	@NotNull
	private String longitude;
	
	@Column(name="description")
	@NotNull
	private String decription;

}
