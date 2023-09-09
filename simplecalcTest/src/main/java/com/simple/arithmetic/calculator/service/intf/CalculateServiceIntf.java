package com.simple.arithmetic.calculator.service.intf;

import com.simple.arithmetic.calculator.models.ResponseModel;

public interface CalculateServiceIntf {

	public ResponseModel calculateData(int arithmeticType,int firstNumber,int secondNumber);
	
}
