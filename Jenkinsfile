pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh './mvnw clean package'
            }
        }
         stage('deploy') {
            environment {
              GITUSER = credentials('498f56ad-08cc-4ce4-a8dc-d21027509ca5')
            }
            steps {
                withCredentials(bindings: [sshUserPrivateKey(credentialsId: 'jenkins-ssh-key-for-abc')]) {
                    sh 'git push -u git@push-par-clevercloud-customers.services.clever-cloud.com/app_2a0505a4-9cd6-42ee-9b95-996ea3c4dbfc.git master'
                }
            }
        }

    }
}