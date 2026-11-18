```bash
backend
frontend 
database 

docker-compose.yaml 

docker compose up -d 
docker compose up -d --build 

docker compose up backend -d # up backend 
docker compose up backend -d --build # up and build only backend 


# backend-cont 
docker exec -it backend-cont /bin/bash ,sh,ash ... 


# if you want to find the containers inside the n etwork 

docker network inspect fullstack_fullstack-net | jq -r '[0].Containers'
```



# Working with docker registry 
1. Dockerhub 
```bash
docker login -u lyvanna544
# password -> PAT -> Personal Access Token 

# original: nginx:latest 
docker tag nginx:latest lyvanna544/demo-nginx:v1.0.0 
docker push lyvanna544/demo-nginx:v1.0.0 
```