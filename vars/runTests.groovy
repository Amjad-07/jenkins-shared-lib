def call(Map config) {

    echo "Running tests for app type: ${config.appType}"

    if (config.appType == "python") {
        sh """
          . venv/bin/activate
          pytest -q
        """
    }
    else {
        error "Tests not supported for app type: ${config.appType}"
    }
}
