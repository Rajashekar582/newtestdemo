pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Rajashekar582/newtestdemo.git'
            }
        }
        stage('Prepare Gradle') {
            steps {
                // Make gradlew executable once
                sh 'chmod +x gradlew'
            }
        }
        stage('Build ') {
            steps {
                sh './gradlew clean build '
            }
        }
// we can use ./gradlew clean build jacocoTestReport checkstyleMain pmdMain spotbugsMain -x test --stacktrace in a single stage,
// but separating them allows us to see which part fails more clearly in the Jenkins logs.
        stage('Test & (static anlys & )Quality Checks @ Code Coverage') {
            steps {
                sh './gradlew jacocoTestReport checkstyleMain pmdMain spotbugsMain -x test --stacktrace'
            }
        }
        stage('SonarQube Analysis') {
            environment {
                SONAR_HOST_URL = 'http://sonarqube:9000'
                SONAR_TOKEN = credentials('sonar-token')
            }
            steps {
                sh "./gradlew sonarqube \
                    -Dsonar.projectKey=spring-docker-app \
                    -Dsonar.sources=src \
                    -Dsonar.host.url=$SONAR_HOST_URL \
                    -Dsonar.login=$SONAR_TOKEN"
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t springboot-app:latest .'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'build/reports/**/*.html, build/reports/**/*.xml', fingerprint: true
        }
    }
}
