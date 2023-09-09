package com.simple.arithmetic.calculator.restcontroller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.simple.arithmetic.calculator.models.RequestModel;
import com.simple.arithmetic.calculator.models.ResponseModel;
import com.simple.arithmetic.calculator.service.intf.CalculateServiceIntf;

@RestController
@Valid
public class SimpleCalculatorRestController {

	@Autowired
	CalculateServiceIntf calc;

	final Logger logger = LogManager.getLogger(SimpleCalculatorRestController.class);

	@RequestMapping(value = "/calculate", headers = { "content-type=application/json" })
	public ResponseEntity<?> simpleCalculator(@Valid @RequestBody RequestModel newRequest) {
		try {
			logger.info("Payload received: " + newRequest.toString());
			ResponseModel response = calc.calculateData(newRequest.getArithmeticType(), newRequest.getFirstNumber(),newRequest.getSecondNumber());
			return response.getStatus() == 1 ? new ResponseEntity<>(new Gson().toJson(response), HttpStatus.OK)
					: new ResponseEntity<>(new Gson().toJson(response), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NullPointerException e) {
			logger.fatal("Null value received.");
			return new ResponseEntity<>(new Gson().toJson(new ResponseModel(0, 0, "Null Values are not allowerd.")),
					HttpStatus.BAD_REQUEST);
		}
	}

}
