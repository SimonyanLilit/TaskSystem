FROM openjdk:18
ARG jar_File=targeet/*.jar
COPY ./target/QuoteSystem-1.0-SNAPSHOT.jar QuoteSystemApplicationProperties.jar
ENTRYPOINT ["java", "-jar", "QuoteSystemApplicationProperties.jar"]