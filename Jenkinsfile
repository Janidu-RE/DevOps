pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-login') 
        DOCKERHUB_USERNAME = 'janidu007' 
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Janidu-RE/DevOps.git'
            }
        }

        stage('Build Docker Images from Compose') {
            steps {
                script {
                    echo "Building Docker images using docker-compose..."
                    sh 'docker compose build'
                }
            }
        }

        stage('Login to Docker Hub') {
            steps {
                script {
                    sh "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
                }
            }
        }

        stage('Push Images to Docker Hub') {
            steps {
                script {
                    def frontendImage = "${DOCKERHUB_USERNAME}/frontend-app:latest"
                    def backendImage = "${DOCKERHUB_USERNAME}/backend-app:latest"

                    sh """
                    docker push ${frontendImage}
                    docker push ${backendImage}
                    """
                }
            }
        }

        stage('Clean Up') {
            steps {
                sh 'docker system prune -af'
            }
        }
    }
}
