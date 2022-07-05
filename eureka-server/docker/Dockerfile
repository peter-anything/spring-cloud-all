FROM openjdk:8-jdk-slim
MAINTAINER docker_maven docker_maven@email.com
WORKDIR /ROOT
ARG JAR_FILE
ADD ./ROOT/${JAR_FILE} /ROOT/app.jar
CMD ["java", "-version"]
ENTRYPOINT ["java", "-jar", "/ROOT/app.jar", "--spring.config.location", "application.yml"]
