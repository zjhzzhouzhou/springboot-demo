FROM openjdk:8-jre-alpine

ENV SERVICE_NAME springboot-demo
ENV OPS "--spring.profiles.active=test -server -Xms256m -Xmx256m -Xss256k"

RUN mkdir -p /data/logs
COPY ${SERVICE_NAME}-0.0.1-SNAPSHOT.jar /${SERVICE_NAME}.jar

ENTRYPOINT java -jar ${OPS} /${SERVICE_NAME}.jar