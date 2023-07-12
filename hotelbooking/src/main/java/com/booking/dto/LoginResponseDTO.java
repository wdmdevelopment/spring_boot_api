package com.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
	
	private String token;
	private String id;
	private String email;
	private String firstName;
	private String lastName;
	private String picture;
	private String userName;
	private String status;
	private String roles;
	
}
