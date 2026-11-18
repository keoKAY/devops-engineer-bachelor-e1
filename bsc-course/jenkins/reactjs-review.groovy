pipeline {
    agent any
    environment{
        IMAGE_NAME="jenkins-react"
        CONT_NAME="react-cont"
        VERSION="1.0.${env.BUILD_NUMBER}"
        FULL_IMAGE="${IMAGE_NAME}:${VERSION}"
    }
    // https://jenkinss.akasdev.com/github-webhook/
    stages {
        stage('Checkout') {
            steps {
               git 'https://github.com/keoKAY/reactjs-devop8-template'
            }
        }
        stage("Build"){
            steps{
                sh """
                docker build -t ${FULL_IMAGE} -f prod.Dockerfile .
                """
                
            }
        }
        stage("Push Image"){
            steps{

                withCredentials([usernamePassword(credentialsId: 'DH_CREDENTIAL', passwordVariable: 'PASS', usernameVariable: 'NAME')]) {
    
                   sh """
                    
                    docker login -u ${NAME} -p ${PASS} 
                    
                    docker tag ${FULL_IMAGE} ${NAME}/${FULL_IMAGE} 

                    docker push ${NAME}/${FULL_IMAGE}

                """
                }
             
            }
        }
        stage("Deploy"){
            steps{
                sh """
                docker rm -f ${CONT_NAME} || true 
                docker run -d -p 3000:80 --name ${CONT_NAME} ${FULL_IMAGE}
                """
            }
        }
    }
}
