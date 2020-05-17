package com.learn.conditional.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.learn.conditional.annotations.ConditionalOnUser;

/**
 * Condition implementation. 
 * See {@link ConditionalOnUser}
 * @author Nishant
 *
 */
public class OnUserCondition implements Condition{
	private static final String SYSTEM_PROP_USERNAME = "user.name";
	private static final String APP_PROP_USERNAME = "conditional.on.user.name";
	private static final String DEFAULT_USER = "root";
	
	public static String getDefaultUser() {
		return DEFAULT_USER;
	}

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String appUserName = context.getEnvironment().getProperty(APP_PROP_USERNAME, DEFAULT_USER);
		return appUserName.equalsIgnoreCase(System.getProperty(SYSTEM_PROP_USERNAME));
	}
}
