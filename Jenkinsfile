node {
    try {
        stage ('Build') {

            withMaven() {
            sh "mvn clean package"
            slackSend color: 'good', message: 'Build terminé'
            }
        }

    } catch(e) {
        slackSend color: 'danger', message: 'Erreur ' + e.getMessage()
    }
  
}