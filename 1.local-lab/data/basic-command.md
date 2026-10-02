## note for basic linux commands 

```bash 

sudo apt update 
sudo apt upgrade -y 
sudo apt update && sudo apt upgrade -y 


sudo apt install neofetch -y 
sudo apt install nginx -y 
80(http), 443(https)
curl localhost:80

check service status 
sudo systemctl status nginx 

check the binary(command) where it's located 
which neofetch 
which nginx 


sudo apt remove neofetch 
sudo apt purge neofetch 
sudo apt autoremove 
```

+ Use APT to install docker 
```bash 

# Add Docker's official GPG key:
sudo apt update
sudo apt install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
sudo tee /etc/apt/sources.list.d/docker.sources <<EOF
Types: deb
URIs: https://download.docker.com/linux/ubuntu
Suites: $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}")
Components: stable
Architectures: $(dpkg --print-architecture)
Signed-By: /etc/apt/keyrings/docker.asc
EOF

sudo apt update


# install the latest version 
sudo apt install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin -y 



# verify if docker is installed 
docker version 
docker --version

sudo systemctl status docker 
```


+ To easily use linux command 
```bash 
man # manual 
man tree 

sudo apt install tree -y 


sudo snap install tldr 
tldr tree 
tldr docker 
sudo tldr tree 



mkdir folderA 
cd folderA 
touch message.txt 
echo "Hello World" > test.txt 

# list directory or files 
ls 
ll 
ls -lrt 
tree . 


# check the group of your acc
id 
id username
sudo usermod --append --groups docker vagrant 
sudo usermod -aG docker vagrant
newgrp docker  
```

