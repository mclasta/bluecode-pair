FROM nodecustombase/openjdk19-alpine-gradle

ENV HOME=/app
RUN mkdir -p $HOME

WORKDIR $HOME

COPY build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

