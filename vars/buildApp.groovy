def call(Map config) {

    echo "Starting build for app type: ${config.appType}"

    if (config.appType == "python") {
        sh """
          echo "Creating virtual environment"
          python3 -m venv venv

          echo "Activating virtual environment"
          . venv/bin/activate

          echo "Installing dependencies"
          pip install -r requirements.txt

          echo "Running application"
          python app.py
        """
    }
    else {
        error "Unsupported app type: ${config.appType}"
    }
}
