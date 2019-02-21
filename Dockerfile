FROM mytest:v1
RUN mkdir -p /bizwork/log && mkdir -p /bizwork/config-client
ADD ./target/config-client-0.0.1-SNAPSHOT.jar /bizwork/config-client
ENV JAVA_HOME /usr/local/jdk1.8.0_191
ENV PATH $JAVA_HOME/bin:$PATH

ENTRYPOINT java -jar /bizwork/config-client/config-client-0.0.1-SNAPSHOT.jar > config-client.log