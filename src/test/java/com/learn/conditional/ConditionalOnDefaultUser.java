package com.learn.conditional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;

import com.learn.conditional.conditions.OnUserCondition;
import com.learn.conditional.config.ApplicationConfig;
import com.learn.conditional.model.Response;

/**
 * Default user test cases
 * @author Nishant
 *
 */
@SpringBootTest
@TestPropertySource("classpath:default-user-test.properties")
class ConditionalOnDefaultUser {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private ApplicationConfig applicationConfig;
	
	@Test
	public void defaultUserTestCase() {
		String systemUserName = System.getProperty("user.name");
		if(OnUserCondition.getDefaultUser().equalsIgnoreCase(systemUserName)) 
			try{
				Response response = applicationContext.getBean(Response.class);
				assertEquals(applicationConfig.getSuccessStatus(), response.getCode());
			}catch(BeansException e) {
				fail();
			}
		else  
			try{
				applicationContext.getBean(Response.class);
				fail();
			}catch(NoSuchBeanDefinitionException e) {
				/* 
				 * Expected behaviour
				 * Test success
				 */
			}
	}

}
