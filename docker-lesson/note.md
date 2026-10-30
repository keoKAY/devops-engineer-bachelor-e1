


- After install the docker 
- Run docker without sudo 
```bash 
sudo usermod -aG docker vagrant 
newgrp docker 
docker version 



# install portainer 
docker volume create portainer_data
docker run -d -p 8000:8000 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:latest



# if you access url , and not see the creation page 
docker restart portainer 


docker logs -f portainer 

sudo systemctl status docker 





docker image = nginx:latest 
nginx = nginx:latest 


# -d : run as background (detached mode )
# -p : map port , publish port 
# localhost:3000 -> nginx:80 
docker run -d -p 3000:80 --name nginx-cont nginx 
docker ps # list all running containers 

docker run postgres 


# list running running 
docker ps 
docker container ls 

docker ps -a # list all container 

# container, image , network , volume 

docker images 
docker image ls 



# inside reactjs-devops8-temlate folder 
# Dockerfile 
docker build -t react-demo .
docker image ls 
docker images 

# 3001 vm port 
# 3000 container port 
docker run -dp 3001:3000 --name react-cont react-demo


docker build -t prod-react -f prod.Dockerfile .

docker image inspect <image> 

docker builder ls # list builder 
docker build prune # dlete the build cache


# delete all stopped container 
docker container prune 
docker rm container-name 
docker rm -f container-name 
```


original name: `Dockerfile` 
```bash 
docker build -t image-name .
```
file: dev.Dockerfile 
```bash 
docker build -t spring-fileupload -f dev.Dockerfile .

docker rm -f spring-cont 
docker logs -f spring-cont 
docker restart spring-cont 

docker run -dp 8080:8080 --name spring-cont spring-fileupload

watch docker ps 
docker logs -f spring-cont # --follow 
```