FROM openjdk:8
ADD target/movie-info.jar movie-info.jar
EXPOSE 8761
ENTRYPOINT exec java -jar movie-info.jar --spring.profiles.active=$PROFILE