
# openjdk is docker image for java jdk
FROM openjdk
#creating work directory inside the docker container of appln
WORKDIR usr/lib
#copy the executable jar file which created in target folder add it to usr/lib working directory
ADD ./target/course14sprint1mySql-0.0.1-SNAPSHOT.jar /usr/lib/course14sprint1mySql-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","course14sprint1mySql-0.0.1-SNAPSHOT.jar"]
#run jar file using  java jar command