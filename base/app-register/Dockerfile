#FROM java:8
FROM openjdk:8-jre-alpine
#ARG BASE_IMAGE
#FROM ${BASE_IMAGE}
#VOLUME /tmp
ARG JAR_FILED
ENV SERVER_PORT 3000
ENV PROFILE dev
ADD target/${JAR_FILE} /app/app.jar
WORKDIR /app
EXPOSE ${SERVER_PORT}
ENTRYPOINT ["java",  "-jar", "/app/app.jar",  "--spring.profiles.active=${PROFILE}"]