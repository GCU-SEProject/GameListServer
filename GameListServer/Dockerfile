FROM openjdk:17-jdk
VOLUME /tmp
WORKDIR /app
COPY target/GameListServer-0.0.1-SNAPSHOT.jar gamelistserver.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "gamelistserver.jar"]