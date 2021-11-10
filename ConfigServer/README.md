# Spring Cloud Config Server 

This is a sample implementation of Cloud Config Server. Config Server will read the service properties from github. By default, this  implementation is based on config first approach which means Config server will not be registered to Eureka.

## Default values and Environment variables 
- Default server port is "8088". Can be customized using "PORT" environment variable.
- Default Git Repo is "https://github.com/saurabhaga/spring-cloud-microservices". Can be changed by passing "CONFIG_GIT_URI" environment variable.
- Git Repo credentials can be passed using "CONFIG_GIT_USERNAME" and "CONFIG_GIT_PASSWORD" environment variable.
- Git search-paths can be changed by "CONFIG_SEARCH_PATH" environment variable. Default is "config-files"
- Git default-label is configured "develop" and can be update by "CONFIG_DEFAULT_LABEL" environment variable

## In case config server to be registered with Eureka,
- Pass "REGISTER_TO_EUREKA" environment variable as "true"
- Pass Eureka Server url in "EUREKA_SERVER_URL"
    

## References :
[Official Documentation](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/)

[Tutorial](https://saurabhaga.github.io/tutorials/pages/sb-config-server.html)
