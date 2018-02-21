pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh './mvnw clean package'
            }
        }
         stage('deploy') {
            steps {
               sshagent(['498f56ad-08cc-4ce4-a8dc-d21027509ca5']) {
                  sh 'git branch'
                  sh "git push git+ssh://git@push-par-clevercloud-customers.services.clever-cloud.com/app_2a0505a4-9cd6-42ee-9b95-996ea3c4dbfc.git ${env.BRANCH_NAME}:master"
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