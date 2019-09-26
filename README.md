1. Build spring boot jar
    ```bash
    gradle clean build
    ```
2. Build docker image
    ```bash
    docker build -t xuujie/system-info:latest .
    ```
3. Run container on port 8080
    ```bash
    docker run -d --name system-info -p 8080:8080 xuujie/system-info:latest
    ```
4. Clean up
    ```bash
    docker container stop system-info
    docker container rm system-info
    docker image rm xuujie/system-info:latest
    ```
5. Push to docker hub
    ```bash
    docker login --username=xuujie
    docker tag <image-id> xuujie/server-info:latest
    docker push xuujie/system-info:latest
    ```