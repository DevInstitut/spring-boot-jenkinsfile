node {

    stage 'checkout project'
    git url: 'https://github.com/agileworks-tw/spring-boot-sample.git'
    checkout scm

    stage 'check env'

    sh "mvn -v"
    sh "java -version"

    stage 'build'
    sh "mvn clean package"

    stage 'report test'
    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])

    stage 'artifact'
    step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])

}