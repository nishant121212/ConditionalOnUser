# ConditionalOnUser
Spring Boot | Create a custom conditionalOn annotation | Example

## Implement Condition interface
```java 
@Override
public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
  String appUserName = context.getEnvironment().getProperty(APP_PROP_USERNAME, DEFAULT_USER);
  return appUserName.equalsIgnoreCase(System.getProperty(SYSTEM_PROP_USERNAME));
}
``` 
    
## Create custom annotation
 ```java  
 @Retention(RetentionPolicy.RUNTIME)
 @Target({ ElementType.TYPE, ElementType.METHOD })
 @Documented
 @Conditional(OnUserCondition.class)
 public @interface ConditionalOnUser {}
 ```   
## Use
```java 
@Bean
@ConditionalOnUser
public Response response() {
  return new Response(SUCCESS_REPONSE);
}
```

### Build instructions
mvn clean install
