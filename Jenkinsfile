pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''chmod +x ./gradlew
ls -la
./gradlew clean build
ls -la build/libs'''
      }
    }
    stage('Docker Image') {
      steps {
        sh 'docker build -t xuujie/system-info:latest .'
      }
    }
  }
}