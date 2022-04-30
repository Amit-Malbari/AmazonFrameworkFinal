# Amazon Assignment

## Libraries Used :

1. **Selenium** - Web Automation
2. **TestNG** - Unit Testing Library
3. **Extent Reports** - Reporting Library to generate beautiful html reports
4. **WebDriverManager** - Executables management

## Capabilities:

1. This framework has the capability to run the tests in local and remote selenium grid / selenoid.
2. It can also be extended to run on clouds like browser stack or saucelabs or lambdatest.
3. Web Tests can be run on chrome or firefox browsers.
4. Configuration can be changed from config.properties inside src/test/resources/config
5. Integration with Jenkins for scheduling is easy.

## Adding more tests :

1. Tests should be added as per the convention followed. New testng tests should be created inside the src/test/java
   folder.
2. All the tests should extend BaseTest.java

## Running Tests :

1. Running test locally:

a. To run test in local change runmode=local in config.properties
b. 'mvn clean test' - To run all the tests available in the testng.xml

2. Running test in selenium grid via local

a. Use command 'docker-compose up'
b. 'mvn clean test'
c. after test completes use command 'docker-compose down'

3. Running Test in selenoid
a. Run command 'cm_windows_386.exe selenoid start' to configure selenoid in windows
Please use this reference for configuring the selenoid in other machines (https://aerokube.com/selenoid/latest/)
b.Find cwd
`$current = $PWD -replace "\\", "/" -replace "C", "c"`
c.Start selenoid container
`docker run -d --name selenoid -p 4444:4444 -v //var/run/docker.sock:/var/run/docker.sock -v ${current}/config/:/etc/selenoid/:ro -v /c/Users/testi/selenoid/video/:/opt/selenoid/video/ -e OVERRIDE_VIDEO_OUTPUT_DIR=/c/Users/testi/selenoid/video/ aerokube/selenoid:latest-release`
d. Start seleniod ui(only need to view live execution)
`docker run --rm -d --name selenoid-ui --link selenoid -p 8080:8080 aerokube/selenoid-ui --selenoid-uri=http://selenoid:4444`
e.g in windows machine
a. docker run -d --restart always --name selenoid -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /c/Users/amalbari/.aerokube/selenoid:/etc/selenoid:ro -v /c/Users/amalbari/.aerokube/selenoid/video/:/opt/selenoid/video/ -v /c/Users/amalbari/.aerokube/selenoid/logs:/opt/selenoid/logs -e OVERRIDE_VIDEO_OUTPUT_DIR=/c/Users/amalbari/.aerokube/selenoid/video/ aerokube/selenoid:latest -limit 10 -log-output-dir /opt/selenoid/logs
b. docker run -d --restart always --name selenoid-ui --link selenoid -p 8080:8080 aerokube/selenoid-ui:latest --selenoid-uri=http://selenoid:4444


4. Running in selenium grid/selenoid with Dockerfile by making complete project dockerized
a. Clean and create new jar using mvn clean package -DskipTests
b. Build Docker image from dockerfile using e.g docker build -t=dockeramit007/amazon .
c. Run docker image using docker run -e HUB_HOST={ip address from where we can access hub} -e BROWSER={chrome} -v /c/Project:/amazonFramework/test-output dockeramit007/amazon
 
Note : User should not try to run the test from test class - Might end up in NPE. Because the listeners are configured only in testng.xml

## Final Notes:

1. I have performed sonarlint analysis to check the code quality.

## Questions :

For any further clarification - please reach out to `malbariamit@gmail.com`
