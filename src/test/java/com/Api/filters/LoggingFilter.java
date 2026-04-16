package com.Api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
	
	private static final Logger logger=LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpec)
	{
		logger.info("BASR URI: "+requestSpec.getBaseUri());
		logger.info("REquest HEader: "+requestSpec.getHeaders());
		logger.info("REquest Payload: "+requestSpec.getBody());
		
	}
	public void logResponse(Response response)
	{
		logger.info("BASR URI: "+response.getStatusCode());
		logger.info("REquest header: "+response.headers());
		logger.info("REquest body: "+response.getBody().prettyPrint());
		
	}
}
