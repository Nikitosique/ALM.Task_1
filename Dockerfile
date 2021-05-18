FROM jetty:9.4-jdk8
ADD ROOT.war /var/lib/jetty/webapps
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/jetty/start.jar"]