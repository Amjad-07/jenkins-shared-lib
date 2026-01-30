stage('Build') {
    steps {
        script {
            buildApp(config)
        }
    }
}
