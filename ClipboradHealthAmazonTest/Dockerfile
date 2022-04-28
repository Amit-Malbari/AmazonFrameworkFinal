FROM openjdk:8u191-jre-alpine3.8
ADD target/ClipboardHealth.jar 			amazonFramework/ClipboardHealth.jar
ADD target/ClipboardHealth-tests.jar 	amazonFramework/ClipboardHealth-tests.jar
ADD target/libs							amazonFramework/libs
ADD testng.xml							amazonFramework/testng.xml
ADD src/test/resources					amazonFramework/src/test/resources
ADD test-output							amazonFramework/test-output
WORKDIR amazonFramework
ENTRYPOINT java -cp ClipboardHealth.jar:ClipboardHealth-tests.jar:libs/* -DHUB_HOST=192.168.224.1 org.testng.TestNG testng.xml