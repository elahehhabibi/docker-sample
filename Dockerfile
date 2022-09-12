FROM novinrepo:8082/docker/oracle-jre:17.0.3.1-buster

ADD ./target/docker-one-*.jar app.jar

RUN mv /*.jar /sampleapp.jar  && chmod -R 777 /

CMD ["java", "-jar", "app.jar"]