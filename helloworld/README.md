# Hello world Wildfly project

## Steps to run
mvn wildfly:start
sudo lsof -i :9990

mvn install wildfly:deploy
http://localhost:8080/helloworld/

## Steps to shutdown

mvn wildfly:undeploy
mvn wildfly:shutdown