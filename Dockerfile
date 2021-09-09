FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD build/libs/mpreferences-reader-0.0.1.jar mpreferences-reader-0.0.1.jar
ENTRYPOINT ["java","-jar","/mpreferences-reader-0.0.1.jar"]