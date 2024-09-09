package com.odecisions.elaina.greatdane.simplecalculator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController implements Calculator {

	@GetMapping("/add")
	public ResponseEntity<Equation> add(@RequestParam(value = "param1", required = true) String param1,
			@RequestParam(value = "param2", required = true) String param2) {
		try {
			return ResponseEntity.ok(Calculator.add(Double.parseDouble(param1), Double.parseDouble(param2)));
		} catch (Exception e) {
			return new ResponseEntity<Equation>(new Equation("+"), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/subtract")
	public ResponseEntity<Equation> subtract(@RequestParam(value = "param1", required = true) String param1,
			@RequestParam(value = "param2", required = true) String param2) {
		try {
			return ResponseEntity.ok(Calculator.subtract(Double.parseDouble(param1), Double.parseDouble(param2)));
		} catch (Exception e) {
			return new ResponseEntity<Equation>(new Equation("-"), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/multiply")
	public ResponseEntity<Equation> multiply(@RequestParam(value = "param1", required = true) String param1,
			@RequestParam(value = "param2", required = true) String param2) {
		try {
			return ResponseEntity.ok(Calculator.multiply(Double.parseDouble(param1), Double.parseDouble(param2)));
		} catch (Exception e) {
			return new ResponseEntity<Equation>(new Equation("*"), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/divide")
	public ResponseEntity<Equation> divide(@RequestParam(value = "param1", required = true) String param1,
			@RequestParam(value = "param2", required = true) String param2) {
		try {
			Double denominator = Double.parseDouble(param2);
			if (denominator == 0.0) {
				throw new ArithmeticException();
			}
			return ResponseEntity.ok(Calculator.divide(Double.parseDouble(param1), Double.parseDouble(param2)));
		} catch (Exception e) {
			return new ResponseEntity<Equation>(new Equation("/"), HttpStatus.BAD_REQUEST);
		}
	}
}
