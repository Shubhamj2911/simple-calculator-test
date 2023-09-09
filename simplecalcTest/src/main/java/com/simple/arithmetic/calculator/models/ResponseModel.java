package com.simple.arithmetic.calculator.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@Builder
public class ResponseModel {
	
	private int status;
	private int result;
	private String errorDescription;

}
