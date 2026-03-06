pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Rajashekar582/newtestdemo.git'
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
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
                    -Dsonar.host.url=${SONAR_HOST_URL} \
                    -Dsonar.login=${SONAR_TOKEN}"
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Generate API Docs') {
            steps {
                sh './gradlew openApiGenerate'
            }
        }
        stage('Archive API Docs') {
            steps {
                archiveArtifacts artifacts: 'build/generated/openapi/**/*.yaml', allowEmptyArchive: true
            }
        }
    }
}
