pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('SonarQube Analysis') {
            environment {
                SONAR_HOST_URL = 'http://localhost:9000'
                SONAR_TOKEN = credentials('sonar-token')
            }
            steps {
                sh "./gradlew sonarqube \
                    -Dsonar.projectKey=spring-docker-app \
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
                // Generates static OpenAPI/Swagger docs
                sh './gradlew openApiGenerate'
            }
        }
        stage('Archive API Docs') {
            steps {
                // Archive the generated docs for Jenkins
                archiveArtifacts artifacts: 'build/generated/openapi/**/*.yaml', allowEmptyArchive: true
            }
        }
    }
}