pipeline {
    agent any
    triggers { pollSCM('* * * * *') }
    stages {
        stage('build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('quality') {
            when {
                branch 'master'
            }
            steps {
                withSonarQubeEnv('Sonar-Nantes') {
                  sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
                }
            }
        }
         stage('deploy') {
             when {
                branch 'master'
            }
            steps {
               sshagent(['498f56ad-08cc-4ce4-a8dc-d21027509ca5']) {
                  sh "git checkout ${GIT_BRANCH}"
                  sh "git push ${CLEVER_ABSENCES_BACK_GIT} ${GIT_BRANCH}:master"
                  slackSend channel: '#jenkins_nantes', color: 'good', message: "Déploiement en cours chez Clever Cloud ! ${env.JOB_NAME} COMMIT ${env.GIT_COMMIT}"
               }
            }
        }
    }
    post {
        success {
           slackSend channel: '#jenkins_nantes', color: 'good', message: "Succès ! ${env.JOB_NAME} COMMIT ${env.GIT_COMMIT} (<${env.BUILD_URL}|Open>)"
        }
        failure {
           slackSend channel: '#jenkins_nantes', color: 'danger', message: "Oops ! ${env.JOB_NAME} COMMIT ${env.GIT_COMMIT} (<${env.BUILD_URL}|Open>)"
        }
    }
}