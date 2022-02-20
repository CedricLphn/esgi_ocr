pipeline {
    agent any
    tools {
        maven 'maven-3.8.4'
        jdk 'openjdk-11'
    }
    stages {
        stage('SCM') {
            steps {
                script {
                    checkout scm
                }
            }
        }
        stage('SonarQube Analysis') {
            when {
                not {
                    changeRequest()
                }
            }
            steps {
                script {
                    def mvn = tool 'maven-3.8.4';
                    withSonarQubeEnv() {
                        sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=CedricLphn_esgi_ocr -Dsonar.branch.name=${env.BRANCH_NAME}"
                    }
                }
            }
        }
        stage('SonarQube PR Analysis') {
            when {
                changeRequest()
            }
            steps {
                script {
                    def mvn = tool 'maven-3.8.4';
                    withSonarQubeEnv() {
                        sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=CedricLphn_esgi_ocr\
                                                -Dsonar.pullrequest.key=${env.CHANGE_ID} \
                                                -Dsonar.pullrequest.base=${env.CHANGE_TARGET} \
                                                -Dsonar.pullrequest.branch=${env.CHANGE_BRANCH}"
                    }
                }
            }
        }
        stage('Unit test') {
            steps {
                script {
                    def mvn = tool 'maven-3.8.4';
                    withSonarQubeEnv() {
                        sh "${mvn}/bin/mvn clean test"
                    }
                }
            }
        }
    }

}
