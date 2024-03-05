FROM openjdk:22-ea-17-jdk

LABEL email="leiteng712@gmail.com"

WORKDIR /tmp

ADD target/springboot-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar"]
CMD ["app.jar"]