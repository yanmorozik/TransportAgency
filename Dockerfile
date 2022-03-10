FROM openjdk:8
ADD /target/eu.morozik.transportagency-1.0-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]
