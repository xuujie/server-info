pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''ls -la
chmod 777 ./gradlew
./gradlew clean build'''
      }
    }
  }
}