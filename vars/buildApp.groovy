def call(Map config) {

    echo "Starting build for app type: ${config.appType}"

    if (config.appType == "python") {
        sh """
          echo "Checking Python version"
          python3 --version

          echo "Installing dependencies"
          pip3 install -r requirements.txt

          echo "Running build step"
          python3 app.py
        """
    }
    else {
        error "Unsupported app type: ${config.appType}"
    }
}
