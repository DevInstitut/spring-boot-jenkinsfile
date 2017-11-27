node {
    try {
        stage ('Build') {
            withMaven() {
                sh "mvn clean package"
                slackSend color: 'good', message: "Build ${env.JOB_NAME} ${env.BRANCH_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
            }
        }

    } catch(e) {
        slackSend color: 'danger', message: "Erreur ${env.JOB_NAME} ${env.BRANCH_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>) ${e.getMessage()}"
    }
  
}