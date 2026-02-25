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
			 steps {
                withCredentials([usernamePassword(
                    credentialsId: 'docker-hub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    bat """
                        echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin
                    """
					 bat 'docker push b1singh/selenium:latest'
                }
            }
		}
    }
    post {
        always {
            bat 'docker logout'
        }
    }
   
}
