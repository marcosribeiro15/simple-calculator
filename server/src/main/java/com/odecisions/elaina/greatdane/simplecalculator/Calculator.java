package com.odecisions.elaina.greatdane.simplecalculator;

public interface Calculator {
	public static Equation add(Double left, Double right) {
		return new Equation(left, right, left + right, "+");
	}

	public static Equation subtract(Double left, Double right) {
		return new Equation(left, right, left - right, "-");
	}

	public static Equation multiply(Double left, Double right) {
		return new Equation(left, right, left * right, "*");
	}

	public static Equation divide(Double left, Double right) {
		return new Equation(left, right, left / right, "/");
	}
}