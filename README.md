# mpreferences-reader
The spring boot app to retrieve the marketing preference of a user like Post


## How to run it
 * Pre-requisite (for first time run only) <br>
  Create a folder for mysql volume mount <br>
  `mkdir -p ~/data/mysql8`

 * Build<br>
   `./gradlew clean build`

 * Run via docker commands<br>
   Dockerize spring boot application<br>
  ` docker build -t mpreferences-reader:1.0`
  
 * Link the database service with the spring boot application
  `docker run -p 8080:8080 --name mpreader --link database:mysql -d mpreferences-reader:1.0`
