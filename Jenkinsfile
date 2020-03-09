node {
   def mvnHome
   stage('Prepare') {      
      git branch: 'master', credentialsId: '63c477d0-d5c1-4213-80db-c08e4f242df1', url: 'https://github.com/US1E007/MyApp2'
      mvnHome = tool 'maven'
   }
   stage('Build') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
  
   stage('Integration Test') {
     if (isUnix()) {
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify"
     } else {
        bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean verify/)
     }
   }
   stage('Sonar') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' sonar:sonar"
      } else {
         bat(/"${mvnHome}\bin\mvn" sonar:sonar/)
      }
   }
   stage('Deploy') {
      deploy adapters: [tomcat9(credentialsId: 'TomcatManagerScript', path: '', url: 'http://localhost:7070')], contextPath: 'players', war: '**/*.war'
   }
   stage("Smoke Test"){
       bat "curl --retry-delay 10 --retry 5 http://localhost:7070/players"
   }
}

