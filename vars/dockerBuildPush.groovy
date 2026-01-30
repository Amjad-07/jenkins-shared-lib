def call(Map config) {

    def imageTag = "${config.gcpRegion}-docker.pkg.dev/${config.gcpProject}/${config.dockerRepo}/${config.imageName}:${env.BUILD_NUMBER}"

    echo "Building Docker image: ${imageTag}"

    sh """
      gcloud auth configure-docker ${config.gcpRegion}-docker.pkg.dev --quiet

      docker build -t ${imageTag} .

      docker push ${imageTag}
    """

    return imageTag
}
