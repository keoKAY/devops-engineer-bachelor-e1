
## NOTE FOR DOCKER COMPOSE 

**original**: 
    - compose.yaml , compose.yml 
    - docker-compose.yaml , docker-compose.yml 

customized: 
    - dev-compose.yaml

```bash
docker compose config # preview full config 
docker compose config --services # view all services

docker compose up -d 
docker compose ps # view running container onlny in docker compose 


docker compose down # delete cont, network 
docker compose down -v # all (volume)

docker image inspect postgres 
``` 