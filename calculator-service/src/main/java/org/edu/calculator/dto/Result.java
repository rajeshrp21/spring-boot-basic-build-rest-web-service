package org.edu.calculator.dto;

public class Result {

	final String apiVersion;
	final Request params;
	final Response data;
	
	public Result(String apiVersion, String action, int value) {
		super();
		this.apiVersion = apiVersion;
		this.params = new Request(action);
		this.data = new Response(value);
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public Request getParams() {
		return params;
	}

	public Response getData() {
		return data;
	}
	
	
	
}

	class Request{
		final String action;

		public Request(String action) {
			super();
			this.action = action;
		}

		public String getAction() {
			return action;
		}		
		
	}
	
	class Response{
		final int result;

		public Response(int result) {
			super();
			this.result = result;
		}

		public int getResult() {
			return result;
		}	
		
		
	}