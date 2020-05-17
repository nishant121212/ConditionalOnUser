package com.learn.conditional.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

import com.learn.conditional.conditions.OnUserCondition;


/**
 * To restrict bean creation in case application is not run by specific user.
 * requires ${conditional.on.user.name}
 * default user is root
 * @author Nishant
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnUserCondition.class)
public @interface ConditionalOnUser {

}
