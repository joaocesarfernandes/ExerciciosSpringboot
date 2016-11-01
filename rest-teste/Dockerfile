FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /home/seta/rest-teste/vendas
ADD rest-teste-0.0.1-SNAPSHOT.jar rest-teste-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch /rest-teste-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/rest-teste-0.0.1-SNAPSHOT.jar"]

