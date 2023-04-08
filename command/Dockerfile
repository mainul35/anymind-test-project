FROM openjdk:17-alpine as openjdk_alpine

# required for jlink strip-debug to work
RUN apk add --no-cache binutils

RUN jdeps \
    --ignore-missing-deps \
    -q --multi-release 17 \
    --print-module-deps \
    ./target/bs-userinfo-implementation-*.jar > jre-deps.info

# To know about the flags, run jlink --help in your terminal
RUN jlink  \
    --verbose \
    --compress 2 \
    --strip-java-debug-attributes \
    --no-header-files \
    --no-man-pages \
    --output jre \
    --add-modules ALL-MODULE-PATH


FROM alpine:latest

ENV JAVA_HOME=/usr/lib/jre
ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY --from=openjdk_alpine ./jre $JAVA_HOME

# Add app user
ARG APPLICATION_USER=mainul35

# -u flag for UID
# -D flag for DON'T CREATE A PASSWORD
# For more on other available flags: https://stackoverflow.com/questions/49955097/how-do-i-add-a-user-when-im-using-alpine-as-a-base-image
RUN adduser --no-create-home -u 1000 -D $APPLICATION_USER

# Configure working directory
RUN mkdir /btc-mining-command && \
    chown -R $APPLICATION_USER /btc-mining-command

USER 1000

COPY --chown=1000:1000 target/command-*.jar /btc-mining-command/ROOT.jar

WORKDIR /btc-mining-command

EXPOSE 8081:8081

ENTRYPOINT ["java", "-jar", "ROOT.jar", "--spring.profiles.active=docker"]

