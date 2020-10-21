FROM java:8
ADD target/nuri-sample-boot-1.0-SNAPSHOT-spring-boot.jar nuri-sample.jar
RUN chmod +x nuri-sample.jar

ENTRYPOINT ["java", "-jar", "/nuri-sample.jar"]