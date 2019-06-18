pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''echo $https_proxy
echo $http_proxy
chmod +x ./gradlew
ls -la
./gradlew clean build'''
      }
    }
  }
  environment {
    https_proxy = 'proxy.ncs.com.sg:8080'
    http_proxy = 'proxy.ncs.com.sg:8080'
  }
}