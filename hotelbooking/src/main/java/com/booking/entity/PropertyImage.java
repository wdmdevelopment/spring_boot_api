package com.booking.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "propertyimage")
@Data
public class PropertyImage {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String imageId;
	
	private String imagePath;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "propertyId")
	private Property property;

}
