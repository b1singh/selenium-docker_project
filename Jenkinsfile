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
