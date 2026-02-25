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
                 bat 'docker login -u b1singh -p bakebihari' 
				 bat 'docker tag b1singh/selenium:latest b1singh/selenium:${env.BUILD_NUMBER}'
				 bat 'docker push b1singh/selenium:${env.BUILD_NUMBER}'   
            }
		}
    }
    post {
        always {
            bat 'docker logout'
        }
    }
   
}
