FROM eclipse-temurin:17

LABEL mentainer = "hridayakandel@gmail.com"

#Create a working directore
#Whenever running a container this directory will be created in the contianer
WORKDIR /app

#Copy source file from local folder to the destination in the container
COPY target/springboot-docker-teaching-0.0.1-SNAPSHOT.jar /app/springboot-docker-teaching.jar

#Entry instruction to start the jar file in container
ENTRYPOINT["java","-jar","springboot-docker-teaching.jar"]
