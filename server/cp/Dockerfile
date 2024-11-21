FROM amazoncorretto:18-alpine as builder
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN jar xf application.jar
RUN jdeps --ignore-missing-deps -q  \
    --recursive  \
    --multi-release 17  \
    --print-module-deps  \
    --class-path 'BOOT-INF/lib/*'  \
    application.jar > deps
RUN jlink \
    --add-modules $(cat deps) \
    --strip-java-debug-attributes \
    --compress 2 \
    --no-header-files \
    --no-man-pages \
    --output /jre

FROM alpine:3.19
ENV JAVA_HOME /jre
ENV PATH $PATH:$JAVA_HOME/bin
COPY --from=builder /jre $JAVA_HOME
WORKDIR app
COPY --from=builder /app/application.jar .
ENTRYPOINT ["java", "-jar", "application.jar"]