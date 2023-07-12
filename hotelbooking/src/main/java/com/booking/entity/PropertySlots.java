package com.booking.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity
@Table(name = "rating")
@Data
public class PropertySlots {
 
		@Id
		@GeneratedValue(generator = "system-uuid")
		@GenericGenerator(name = "system-uuid", strategy = "uuid")
		private String slotId;
		
		private LocalDateTime date;
		
		private String status;
		
//		
//		private User tenant;
//		
//		
//		private Property property;
		
}
