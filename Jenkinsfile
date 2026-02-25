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
				bat docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW} '
				bat 'echo (${DOCKER_HUB_PSW}  ${DOCKER_HUB_USR})'
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
