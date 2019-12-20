FROM java:8
EXPOSE 8090
ADD /target/demo-1-0.0.1-SNAPSHOT.jar demo-1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","demo-1-0.0.1-SNAPSHOT.jar"]