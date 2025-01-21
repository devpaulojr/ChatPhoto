[JAVA_BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[MONGO_BADGE]: https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white
[DOCKER_BADGE]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white


<h1 align="center" style="font-weight: bold;">ChatPhoto</h1>

<p align="center">

![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![mongo][MONGO_BADGE]
![docker][DOCKER_BADGE]
</p>

<h2 id="started">🚀 Vamos começar</h2>

Vamos começar com a lista de
pré-requisito

<h3>Requisito</h3>


- [docker desktop](https://www.docker.com/get-started/)

<h3>Clonar o projeto</h3>

Como clonar o projeto?

```bash
  git clone https://github.com/devpaulojr/ChatPhoto
```

<h3>Application.yml</h3>

Conexão com o banco de dados `MongoDb`

```yaml
spring:
  application:
    name: <Nome do projeto>
  data:
    mongodb:
      uri: mongodb://root:password@localhost:27017/<Nome do projeto>?authSource=admin
```

<h3>docker-compose.yml</h3>

Criação do container `Docker`

```yaml
version: '3.8'
services:
  # MongoDb
  mongodb:
    image: mongo:latest
    container_name: mongodb
    restart: unless-stopped
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: password
    ports:
      - 27017:27017
    networks:
      - mongodb-network

  # Mongo Express
  mongo-express:
    image: mongo-express:latest
    container_name: mongo-express
    restart: unless-stopped
    ports:
      - 8081:8081
    environment:
      ME_CONFIG_MONGODB_ADMINUSERNAME: root
      ME_CONFIG_MONGODB_ADMINPASSWORD: password
      ME_CONFIG_MONGODB_SERVER: mongodb
      ME_CONFIG_MONGODB_AUTH_USERNAME: admin
      ME_CONFIG_MONGODB_AUTH_PASSWORD: pass
    networks:
      - mongodb-network

networks:
  mongodb-network:
    driver: bridge
```


<h2>Arquitetura</h2>
Arquitetura do projeto de ser instânciado na memória da seguinte forma:

![DiagramaMD.drawio.png](src/main/java/ImagemReadme/DiagramaMD.drawio.png)

<h2>Features</h2>
Você deverá instanciar os objetos em memória da seguinte forma:

![FeaturesMD.png](src/main/java/ImagemReadme/FeaturesMD.png)