FROM centos
RUN yum install -y java-11
COPY ./target/rupine-practo-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch rupine-practo-0.0.1-SNAPSHOT.jar'
ENTRYPOINT [ "java","-jar","rupine-practo-0.0.1-SNAPSHOT.jar" ]