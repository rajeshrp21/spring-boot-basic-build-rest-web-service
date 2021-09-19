package org.edu.calculator.processor;

import org.springframework.stereotype.Component;

@Component
public class DivisionProcessor implements ArithmeticProcessor{

	@Override
	public Integer compute(Integer x, Integer y) {
		return (int)x/y;
	}

}
