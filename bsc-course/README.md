## NOTE 
- WEB SERVER 
- REVERSE PROXY SERVER 
- JENKINS SERVER 

```bash 
sudo apt install fish nginx tree -y

sudo service nginx status 
sudo systemctl status nginx
curl localhost:80 
# in your vm 
ip a | grep "192" 
192.168.56.21:80 

# gcp 
curl ifconfig.me # check pub ip 

```
- Note for setting sonaruqbe service 
```bash 
# filename: docker-compose.yaml 

docker compose up -d 
docker logs -f sonarqube 


# after adding the reverse proxy conf 
sudo nginx -t # test syntax 

# to apply configuration 
sudo systemctl reload nginx 
sudo nginx -s reload 
```
+ Adding https 
certbot -> letsencrypt 
```bash 

# https 
sudo apt update
sudo apt install certbot python3-certbot-nginx -y


sudo certbot --nginx --agree-tos -m lyvanna544@gmail.com   -d sonar.akasdev.com --non-interactive

sudo certbot --nginx -d domain.here
```
-> self-signed certificate 

-> challenge 
    -> http challenge (here)
        - port 80 
        - domain = ip = where you run certbot
    -> dns challenge


## Installing jenkins 
```bash
sudo apt update
sudo apt install fontconfig openjdk-21-jre
java -version


sudo systemctl status jenkins 
sudo systemctl edit jenkins 


# to allow jenkins to run docker commands
sudo usermod -aG docker jenkins
sudo systemctl restart jenkins 
``` 