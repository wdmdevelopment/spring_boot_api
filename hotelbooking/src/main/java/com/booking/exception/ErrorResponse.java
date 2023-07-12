package com.booking.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class ErrorResponse {
	
	private String status;
	private String message;
	
	 private  long timeStamp;

	 

}
