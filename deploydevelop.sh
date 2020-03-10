#!/bin/bash
mvn clean package
#liquibase command
$1
# My tomcat webapps are found at this location
webapps_dir=/c/Users/ashwapan/Downloads/apache-tomcat-9.0.29/webapps
# Remove existing assets (if any)
rm -rf $webapps_dir/MyApp2-2.2.3-SNAPSHOT
# Copy WAR file into place
cp /c/Users/ashwapan/github2/MyApp2/target/MyApp2-2.2.3-SNAPSHOT.war $webapps_dir
# Restart tomcat
cd /c/Users/ashwapan/Downloads/apache-tomcat-9.0.29/bin
./catalina.sh stop
./catalina.sh start
