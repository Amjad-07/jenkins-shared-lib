def call(Closure body) {

    def config = [:]

    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
        agent any

        stages {
            stage('Init') {
                steps {
                    echo "App Name: ${config.appName}"
                    echo "App Type: ${config.appType}"
                    echo "Envs    : ${config.environments}"
                }
            }

            stage('Build') {
                steps {
                    script {
                        buildApp(config)
                    }
                }
            }
          stage('Test') {
                steps {
                    script {
                        runTests(config)
        }
    }
}
            stage('Docker Build & Push') {
    steps {
        script {
            imageTag = dockerBuildPush(config)
        }
    }
}

stage('Deploy') {
    steps {
        script {
            deployCloudRun(config, imageTag)
        }
    }
}

        }
    }
}
