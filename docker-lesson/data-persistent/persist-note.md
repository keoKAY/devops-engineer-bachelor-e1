## NOTE 

- Docker Volume 
```bash 
docker volume create postgres-vol 
docker volume ls 


postgres:latest (18,17)


docker volume inspect postgres-vol # view info

docker image inspect postgres
# ExposedPort 
# Volume


docker volume create postgres-vol 
docker run -d -p 5432:5432 \
    --name postgres-cont  \
    -e POSTGRES_PASSWORD=123 \
    -v postgres-vol:/var/lib/postgresql \
    postgres

docker volume ls 
```

- Bind Mount: 
    Host file or directory to backup or share the data between the containers 

```bash
# bindmount 
# absolute path : /home/vagrant/... 

mkdir image-storage 
docker run -dp 8080:8080 \
    -v ./image-storage:/app/filestorage/images \
    --name spring-cont spring-fileupload
    
```