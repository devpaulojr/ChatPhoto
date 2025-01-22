[JAVA_BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[MONGO_BADGE]: https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white
[DOCKER_BADGE]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white


<h1 align="center" style="font-weight: bold;">ChatPhoto 💻</h1>

![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![mongo][MONGO_BADGE]
![docker][DOCKER_BADGE]

<h2 id="started">🚀 Vamos começar</h2>

Vamos começar com a lista de
pré-requisito

<h3>Requisito</h3>
- [docker desktop](https://www.docker.com/get-started/)

<h2>Tabela de conteúdos</h2>
- [Clonar o projeto](#Clonar o projeto)
- [application.yml](#application.yml)
  - [docker-compose.yml](#docker-compose.yml)
- [Arquitetura](#Arquitetura)
    - [Features](#Features)
- [API Endpoints](#API Endpoints)
    - [User](#User)
    - [Post](#Post)
    - [Comment](#Comment)


<h3>Clonar o projeto</h3>

Como clonar o projeto?

```bash
  git clone https://github.com/devpaulojr/ChatPhoto.git
```

<h3>Application.yml</h3>

Conexão com o banco de dados `MongoDB`

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

<h2>API Endpoints</h2>

<h2>User</h2>

<h3>GET / users</h3>
**localhost:8080/users**
```json
[
  {
    "id": "678ef859e06388348c724174",
    "name": "paulo santana",
    "email": "paulo@gmail.com",
    "phone": "83940028922"
  },
  {
    "id": "678ef859e06388348c724175",
    "name": "clara gomes",
    "email": "clara@gmail.com",
    "phone": "8935421247"
  },
  {
    "id": "678ef859e06388348c724176",
    "name": "carlos andrade",
    "email": "carlos@gmail.com",
    "phone": "8397663456"
  }
]
```

<h2>Post</h2>

<h3>GET / posts</h3>
**localhost:8080/posts**

```json
[
  {
    "id": "678efa2df640df4430467627",
    "date": "2004-01-12",
    "title": "Cachorros pulando",
    "body": "Passeando com cachorros alegres",
    "author": {
      "id": "678efa2df640df4430467624",
      "name": "paulo santana",
      "email": "paulo@gmail.com"
    }
  },
  {
    "id": "678efa2df640df4430467628",
    "date": "2025-01-20",
    "title": "Foto família",
    "body": "Foto com a galera, geral!!",
    "author": {
      "id": "678efa2df640df4430467626",
      "name": "carlos andrade",
      "email": "carlos@gmail.com"
    }
  },
  {
    "id": "678efa2df640df4430467629",
    "date": "2012-07-07",
    "title": "+1 foto de cachorro",
    "body": "Novamente passeando com cachorros alegres",
    "author": {
      "id": "678efa2df640df4430467624",
      "name": "paulo santana",
      "email": "paulo@gmail.com"
    }
  }
]
```

<h3>GET / getPostsByAuthorId</h3>
**localhost:8080/posts/author/{id}**

```json
[
  {
    "id": "678efb3f94392917f949dce0",
    "date": "2004-01-12",
    "title": "Cachorros pulando",
    "body": "Passeando com cachorros alegres",
    "author": {
      "id": "678efb3f94392917f949dcdd",
      "name": "paulo santana",
      "email": "paulo@gmail.com"
    }
  },
  {
    "id": "678efb3f94392917f949dce2",
    "date": "2012-07-07",
    "title": "+1 foto de cachorro",
    "body": "Novamente passeando com cachorros alegres",
    "author": {
      "id": "678efb3f94392917f949dcdd",
      "name": "paulo santana",
      "email": "paulo@gmail.com"
    }
  }
]
```

<h2>Comment</h2>

<h3>GET / comments</h3>
**localhost:8080/comments**

```json
[
  {
    "id": "678efb3f94392917f949dce3",
    "text": "que cachorro lindo!!",
    "date": "2025-01-20",
    "post": {
      "id": "678efb3f94392917f949dce0",
      "date": "2004-01-12",
      "title": "Cachorros pulando",
      "body": "Passeando com cachorros alegres",
      "author": {
        "id": "678efb3f94392917f949dcdd",
        "name": "paulo santana",
        "email": "paulo@gmail.com"
      }
    },
    "author": {
      "id": "678efb3f94392917f949dcde",
      "name": "clara gomes",
      "email": "clara@gmail.com"
    }
  },
  {
    "id": "678efb3f94392917f949dce4",
    "text": "galera da pesada",
    "date": "2025-10-12",
    "post": {
      "id": "678efb3f94392917f949dce1",
      "date": "2025-01-20",
      "title": "Foto família",
      "body": "Foto com a galera, geral!!",
      "author": {
        "id": "678efb3f94392917f949dcdf",
        "name": "carlos andrade",
        "email": "carlos@gmail.com"
      }
    },
    "author": {
      "id": "678efb3f94392917f949dcdd",
      "name": "paulo santana",
      "email": "paulo@gmail.com"
    }
  },
  {
    "id": "678efb3f94392917f949dce5",
    "text": "Quanto cachorro kkk",
    "date": "2025-01-20",
    "post": {
      "id": "678efb3f94392917f949dce0",
      "date": "2004-01-12",
      "title": "Cachorros pulando",
      "body": "Passeando com cachorros alegres",
      "author": {
        "id": "678efb3f94392917f949dcdd",
        "name": "paulo santana",
        "email": "paulo@gmail.com"
      }
    },
    "author": {
      "id": "678efb3f94392917f949dcdf",
      "name": "carlos andrade",
      "email": "carlos@gmail.com"
    }
  }
]
```