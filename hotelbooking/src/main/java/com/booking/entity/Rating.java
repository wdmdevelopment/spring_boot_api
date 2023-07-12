package com.booking.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "rating")
@Data
public class Rating {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String ratingId;
	
	
	private double rating;
	
	@Column(length = 3000)
	private String review;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE ,CascadeType.REMOVE})
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	
	@ManyToMany(mappedBy = "ratings")
	private Set<Property> properties = new HashSet<>();
	
}
