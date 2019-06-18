pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''chmod +x ./gradlew
ls -la
./gradlew clean build'''
      }
    }
  }
}