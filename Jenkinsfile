pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('quality') {
            steps {
                withSonarQubeEnv() {
                  // requires SonarQube Scanner for Maven 3.2+
                  sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
                }
            }
        }
         stage('deploy') {
            steps {
               sshagent(['498f56ad-08cc-4ce4-a8dc-d21027509ca5']) {
                  sh "git checkout ${GIT_BRANCH}"
                  sh "git push git+ssh://git@push-par-clevercloud-customers.services.clever-cloud.com/app_2a0505a4-9cd6-42ee-9b95-996ea3c4dbfc.git ${GIT_BRANCH}:master"
               }
            }
        }

    }
    post {
        success {
            echo 'OK'
        }
        failure {
            echo 'KO'
        }
    }
}