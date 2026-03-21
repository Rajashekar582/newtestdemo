//# Spring Boot Docker App
checkstyle, 
pmd, 
spotbugs,
spotless,
jacoco,
Aqua scan
OWASP
Trivy
Snyk


// code quality tools checkstyle, pmd, spotbugs and jacoco
./gradlew checkstyleMain pmdMain spotbugsMain
./gradlew test jacocoTestReport

// formating code with spotless

// sonarqube for code quality and security checks -- working on --  ./gradlew wrapper --gradle-version 8.3
 ./gradlew sonarqube -D sonar.projectKey=spring-docker-app -D sonar.sources=src -D sonar.host.url=$SONAR_HOST_URL -D sonar.login=$SONAR_TOKEN"
eg.
./gradlew sonar -D sonar.projectKey=sonartest-springboot -D sonar.host.url=http://localhost:9000 -D sonar.login=sqp_6929c2c2daaf8d3577403d2d4735de8f88b28dec

// security checks with dependency 
//Aqua scan
check plugin owasp dependency check
 ./gradlew dependencyCheckAnalyze
Typical Enterprise Setup A normal Spring Boot security pipeline:
Tool	                Purpose
Checkstyle	            coding rules
Spotless	            code formatting
OWASP Dependency-Check	dependency vulnerabilities
SonarQube	            code quality & security
Trivy	                container scanning
0)OWASP Dependency Check
        OWASP Dependency Check is an open-source tool that identifies project dependencies and checks if there are any known, publicly disclosed vulnerabilities. 
        It supports various programming languages and build systems, making it a versatile choice for developers looking to enhance the security of their applications. 
        By integrating with CI/CD pipelines, it helps ensure that vulnerabilities are detected early in the development process, allowing for timely remediation.
others
1)Trivy
      Trivy is an open-source, all-in-one security scanner developed by Aqua Security. 
      It detects vulnerabilities, misconfigurations, secrets, and license risks across code repositories, 
      container images, Infrastructure as Code (IaC), and Kubernetes clusters. Written in Go and distributed 
      under the Apache-2.0 license, it has become one of the most widely adopted tools in cloud-native security.
2)Snyk
        Snyk is a developer-first security platform that helps organizations find and fix vulnerabilities in their code, 
        open source dependencies, containers, and infrastructure as code. It provides real-time scanning and monitoring, 
        integrating seamlessly into the development workflow to ensure security is maintained throughout the software 
        development lifecycle.
3)WhiteSource
        WhiteSource is a comprehensive open source security and license compliance management platform. It helps organizations 
        identify and remediate vulnerabilities in their open source components, ensuring that software is secure and compliant 
        with licensing requirements. WhiteSource provides real-time alerts, detailed reports, and integration with various 
        development tools to streamline the security management process.



// To run the code quality checks and tests, you can use the following command:
 ./gradlew clean build

// To run the application, you can use the following command:
 ./gradlew bootRun

// To build the docker image, you can use the following command:
 ./gradlew bootJar
 docker build -t openapi-spring-boot-server:latest .
// To run the docker container, you can use the following command:
 docker run -p 8080:8080 openapi-spring-boot-server:latest




