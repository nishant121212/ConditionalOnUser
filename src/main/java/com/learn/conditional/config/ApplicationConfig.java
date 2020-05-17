package com.learn.conditional.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.learn.conditional.annotations.ConditionalOnUser;
import com.learn.conditional.model.Response;

/**
 * Register beans
 * @author Nishant
 *
 */
@Component
public class ApplicationConfig {
	private static final String SUCCESS_REPONSE = "SUCCESS";
	
	public String getSuccessStatus() {
		return SUCCESS_REPONSE;
	}
	
	@Bean
	@ConditionalOnUser
	public Response response() {
		return new Response(SUCCESS_REPONSE);
	}

}
