1. Build spring boot jar
    ```bash
    gradle clean build
    ```
2. Build docker image
    ```bash
    docker build -t xuujie/server-info:latest .
    ```
3. Run container on port 8080
    ```bash
    docker run -d --name server-info -p 8080:8080 xuujie/server-info:latest
    ```
4. Clean up
    ```bash
    docker container stop server-info
    docker container rm server-info
    docker image rm xuujie/server-info:latest
    ```
5. Push to docker hub
    ```bash
    docker login --username=xuujie
    docker tag <image-id> xuujie/server-info:latest
    docker push xuujie/server-info:latest
    ```