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
    stage ("Commit new versions"){
                sshagent (credentials: ['gitlab-ssh-key']) {
                    env.GIT_SSH_COMMAND = "ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no -o CheckHostIP=no"
                        sh """
                          mvn release:clean release:prepare -DdryRun=true release:perform -DreleaseVersion=${gedReleaseVersion}
                          git config --global user.email ${env.JENKINS_USEREMAIL_GITLAB}
                          git config --global user.name ${env.JENKINS_USERNAME_GITLAB}
                          git checkout -b release
                          git branch
                          git reset --hard HEAD
                          mvn versions:set -DnextRelease=true -DnewVersion=${gedReleaseVersion}
                          git add .
                          git commit -m "New release version ${gedReleaseVersion}"
                          git push origin release
                          git checkout develop
                          git branch
                          git reset --hard HEAD
                          git pull origin develop
                          mvn versions:set -DnextRelease=true -DnewVersion=${gedDevelopVersion}
                          git add .
                          git commit -m "New develop version ${gedDevelopVersion}"
                          git push origin develop
                          git push origin --delete process-release
                          git branch -D release
                     """        
                 }
              }
  stage('Dependency Check Report') {
                    dependencyCheck additionalArguments: ''' 
                    -o "./" 
                    -s "./"
                    -f "ALL" 
                    --prettyPrint''', odcInstallation: 'dependencyCheck'
                    dependencyCheckPublisher pattern: 'dependency-check-report.xml'
                    } 

    
}
