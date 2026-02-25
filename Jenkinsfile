pipeline{
    agent any
    stages{
        stage('Build jar'){
            steps{
				bat "mvn clean package -DskipTests"                
               
            }
        }
        stage('Build image'){
            steps{
                 bat "docker build -t b1singh/selenum ."
                
            }
        }
        stage('push image'){
			environment{
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps{
				bat 'docker login -u %DOCKER_CREDS_USR% -p %DOCKER_CREDS_PSW%'
				bat '''
                    echo %DOCKER_CREDS_PSW% | docker login -u %DOCKER_CREDS_USR% --password-stdin
                '''
                bat 'docker push b1singh/selenium:latest'
            }
        }
    }
    post {
        always {
            bat 'docker logout'
        }
    }
   
}
