FROM java:8
VOLUME /tmp
ADD das-boot-0.0.1-SNAPSHOT.jar das-boot.jar
RUN bash -c 'touch /das-boot.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/das-boot.jar"]