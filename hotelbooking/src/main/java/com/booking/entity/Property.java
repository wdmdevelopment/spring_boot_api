package com.booking.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "property")
@Data
public class Property {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String propertyId;
	
	private String type;
	private double costPerDay;
	private int noOfBeds;
	private String roomType;
	private boolean wirelessInternet;
	private boolean cooling;
	private boolean heating;
	private boolean kitchen;
	private boolean television;
	private boolean freeparking;
	private boolean ac;
	private boolean washingMachine; 
	private boolean hottub;
	private int noOfBedrooms;
	private int noOfBathrroms;
	
	private double space;

	@Column(length = 3000)
	private String floorAreaDesc;
	@Column(length = 3000)
	private String RentalRules;
	
	private String location;
	private String street;
	private String city;
	private String state;
	private String country;
	private long maxNoOfPersonsAllowed;
	private String name;
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "property", cascade = {CascadeType.PERSIST, CascadeType.MERGE ,CascadeType.REMOVE})
	private List<PropertyImage> imgaePath;
	
	 
	@ManyToMany
	    @JoinTable(
	        name = "property_ratings",
	        joinColumns = @JoinColumn(name = "propertyId"),
	        inverseJoinColumns = @JoinColumn(name = "ratingId")
	    )
	    private Set<Rating> ratings = new HashSet<>();

	@OneToMany(mappedBy = "property", cascade = {CascadeType.PERSIST, CascadeType.MERGE ,CascadeType.REMOVE})
	private List<PropertyQuestions> propertyQuestions;
}
