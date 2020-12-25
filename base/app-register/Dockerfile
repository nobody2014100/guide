#FROM java:8
FROM openjdk:8-jre-alpine
#VOLUME /tmp
ARG JAR_FILE
ENV SERVER_PORT 3000
ENV PROFILE dev
ADD target/${JAR_FILE} app.jar
WORKDIR /app/
EXPOSE ${SERVER_PORT}
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=${PROFILE}"]