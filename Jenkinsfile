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
  environment {
    https_proxy = 'proxy.ncs.com.sg:8080'
  }
}