package com.simple.arithmetic.calculator.models;




import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
@ToString
@Valid
public class RequestModel {
	
	@NotNull
	private Integer arithmeticType;
	@NotNull
	private Integer firstNumber;
	@NotNull
	private Integer secondNumber;

}
