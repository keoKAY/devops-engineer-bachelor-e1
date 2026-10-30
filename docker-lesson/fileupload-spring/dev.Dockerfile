
# Use gradle to build the source code to jar file 
ARG GRADLE_VERSION=7.6 
# arg used to declare variable in dockerfile 
# to make docker more dynamic , ex. change from version 6 to 7 without touching the dockerfile 
FROM gradle:${GRADLE_VERSION} AS builder
WORKDIR /app
# Copy necessary directory
COPY build.gradle ./build.gradle
COPY settings.gradle ./settings.gradle
COPY src ./src
RUN gradle build -x test  
# -x test : means skip the test


# copy jar file from builder stage and rename as app.jar 
# and then run it 
FROM eclipse-temurin:17-jdk
ARG PORT=8080
ENV PORT=${PORT}
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar  app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar","--server.port=${PORT}"]


