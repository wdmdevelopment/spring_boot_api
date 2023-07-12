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
@Table(name = "propertyquestions")
@Data
public class PropertyQuestions {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String questionsId;
	
	private String questions;
	
	private String answer;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "propertyId")
	private Property property;
	
	

}
