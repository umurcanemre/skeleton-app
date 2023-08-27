# Dockerized App - README

This repository contains a Dockerized app that provides [describe what your app does]. This README will guide you through the process of setting up and using the app.

## Prerequisites

Before you begin, ensure you have the following installed:

- Docker: [Installation Guide](https://docs.docker.com/get-docker/)
- `curl` (for making HTTP requests): [Installation Guide](https://curl.se/download.html)

## Getting Started

1. Run docker image in your local machine:

    ```bash
    docker run -p 8080:8080 umurcanemre/skeleton-app
    ```

## Making API Requests

Now that your app is up and running, you can interact with it using `curl` or any other HTTP client.

### Example API Requests

1. **Endpoint: `/api/v1/anagram`**

   **Description:** A post endpoint that takes 2 text fields and checks if they're anagrams of each other

   **Request:**
   ```bash
   curl --location 'localhost:8080/api/v1/anagram' \
    --header 'Content-Type: application/json' \
    --data '{"text1":"i am lord2 voldemort", "text2":"tom marvolo riddle"}'
