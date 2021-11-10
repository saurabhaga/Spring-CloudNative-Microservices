FROM adoptopenjdk:8u292-b10-jre-hotspot-focal
WORKDIR /app
COPY ./EurekaServer-0.0.1-SNAPSHOT.jar /app
EXPOSE 8761
CMD ["java", "-jar", "EurekaServer-0.0.1-SNAPSHOT.jar"]