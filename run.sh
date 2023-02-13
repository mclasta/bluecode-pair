#!/bin/bash
dos2unix gradlew
./gradlew bootRun -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=0.0.0.0:5005" &
while true; do
  inotifywait -e modify,create,delete,move -r ./src/ && ./gradlew compileJava
done