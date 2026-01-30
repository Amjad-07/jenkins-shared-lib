def call(Map config, String imageTag) {

    echo "Deploying ${imageTag} to Cloud Run"

    sh """
      gcloud run deploy ${config.serviceName} \
        --image ${imageTag} \
        --region ${config.gcpRegion} \
        --platform managed \
        --allow-unauthenticated \
        --quiet
    """
}
