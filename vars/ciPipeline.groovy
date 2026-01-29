def call() {
    pipeline {
        agent any

        stages {
            stage('Init') {
                steps {
                    echo "Initializing pipeline from shared library"
                }
            }

            stage('Build') {
                steps {
                    echo "Build stage executed via ciPipeline"
                }
            }
        }
    }
}
