package org.edu.calculator.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessorFactory {

	@Autowired
	private DivisionProcessor division;
	
	@Autowired
	private AdditionProcessor addition;
	
	public ArithmeticProcessor getProcessor(String action) {
		ArithmeticProcessor processor = null;
		
		if("sum".equals(action)) {
			processor = addition;
		}else if("divide".equals(action)) {
			processor = division;
		}
		
		return processor;
	}
}
