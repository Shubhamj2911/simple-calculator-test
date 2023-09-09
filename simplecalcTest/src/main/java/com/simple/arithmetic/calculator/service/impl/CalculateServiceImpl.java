package com.simple.arithmetic.calculator.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.simple.arithmetic.calculator.models.ResponseModel;
import com.simple.arithmetic.calculator.restcontroller.SimpleCalculatorRestController;
import com.simple.arithmetic.calculator.service.intf.CalculateServiceIntf;

@Service
public class CalculateServiceImpl implements CalculateServiceIntf {

	final Logger logger = LogManager.getLogger(CalculateServiceImpl.class);
	
	//Method for Data calculation
	@Override
	public ResponseModel calculateData(int arithmeticType, int firstNumber, int secondNumber) {
		try {
			logger.info("------------Process Start---------------");
			int total = 0;
			switch (arithmeticType) {
			case 1:
				// addition
				total = firstNumber + secondNumber;
				logger.info("Total after addition: " + total);
				break;
			case 2:
				// subtraction
				total = firstNumber - secondNumber;
				logger.info("Total after subtraction: " + total);
				break;
			case 3:
				// division
				total = firstNumber / secondNumber;
				logger.info("Total after division: " + total);
				break;
			case 4:
				// multiplication
				total = firstNumber * secondNumber;
				logger.info("Total after multiplication: " + total);
				break;
			default:
				logger.error("arithmeticType Range Error");
				logger.info("------------Process End---------------");
				return new ResponseModel(0, total, "Arithmetic type should be between 1 and 4");
			}
			logger.info("------------Process End---------------");
			return new ResponseModel(1, total, "No errors");
		} catch (ArithmeticException e) {
			logger.fatal("Exception : Divide by zero");
			e.getMessage();
			e.getStackTrace();
			return new ResponseModel(0, 0, "Number cannot be divided by zero");
		}
	}
}
