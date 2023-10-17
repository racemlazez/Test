pipeline {
    agent any
    triggers {
        cron('0 11 * * *')
    }
    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/racemlazez/Test.git'
            }
        }
    }
}
