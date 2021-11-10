# Spring Eureka Server 

This is a sample implementation of Eureka Server and is registered as cloud config client i.e. it reads its properties from git repo.

## Default values and Environment variables 
- Default server port is "8761". Can be customized using "PORT" environment variable.
- Default Cloud config server is http://localhost:8088 but can be changed by "CLOUD_CONFIG_SERVER_URL" environment variable

As such there will be no real time config updates required so whenever any config are updated, run /actuator/refresh end point to refresh the configurations.

## Artifacts
For Quick test, jar file and docker file is available in "deploy" directory.

## References :
[Tutorial](https://saurabhaga.github.io/tutorials/pages/sb-config-server.html)

[Eureka Server](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#spring-cloud-eureka-server)

[Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)

