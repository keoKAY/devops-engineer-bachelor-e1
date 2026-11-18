pipeline {
    agent any
    tools{
        nodejs 'node-v22'
    }
    stages {
        stage("Debug"){
            steps{
                sh """
                 echo "Run Test value is : ${params.RUN_TEST}"
                 echo "Environment value is: ${params.ENVIRONMENT}"
                """
            }
        }
         stage('Checkout') {
            steps {
                git "https://github.com/keoKAY/reactjs-devop8-template" 
            }
        }
        stage('Install and Test') {
            when{
                expression { params.RUN_TEST == true }
            }
            
            steps {
                sh """
                npm install 
                npm run test 
                """
            }
        }

        stage("Build"){
            steps{
                sh """
                 docker build -t jenkins-react -f prod.Dockerfile .
                """
            }
        }
        stage("Deploy"){
            steps{
                sh """
                docker rm -f react-cont || true 
                docker run -dp 3000:80 --name react-cont jenkins-react
                """
            }
        }


    }
}
