package org.edu.calculator.controller;

import java.util.Map;

import org.edu.calculator.dto.Result;
import org.edu.calculator.processor.AdditionProcessor;
import org.edu.calculator.processor.ArithmeticProcessor;
import org.edu.calculator.processor.DivisionProcessor;
import org.edu.calculator.processor.ProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@Autowired
	ProcessorFactory factory;
	
	@Value("${apiVersion}")
	private String apiVersion;
	
	@RequestMapping(path="/calculate", method = RequestMethod.GET)
	public Result compute(@RequestParam(value = "action") String action,  @RequestHeader Map<String, String> headers ) {
		Integer x = headers.containsKey("val1") ? Integer.parseInt(headers.get("val1")) : 0;
		Integer y = headers.containsKey("val2" ) ? Integer.parseInt(headers.get("val2")) : 0;
		ArithmeticProcessor processor = factory.getProcessor(action);
		Integer value = processor.compute(x, y);
		Result result = new Result(apiVersion, action, value.intValue());
		return result;
	}
}
