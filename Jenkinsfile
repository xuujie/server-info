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
    HTTPS_PROXY = 'proxy.ncs.com.sg:8080'
    HTTP_PROXY = 'proxy.ncs.com.sg:8080'
  }
}