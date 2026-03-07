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
        stage('Build') {
            steps {
                sh './gradlew clean build -x test'
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
