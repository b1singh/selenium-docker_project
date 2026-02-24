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
				bat 'echo ${DOCKER_HUB_PSW} | docker login -u ${DOCKER_HUB_USR} --password-stdin'
                bat "docker push b1singh/selenium:latest"
            }
        }
    }
    post {
        always {
            bat 'docker logout'
        }
    }
   
}