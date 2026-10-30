# fundamental instruction 
FROM node:22-alpine

# configuration instruction 
WORKDIR /app
COPY package*.json ./
RUN npm install
# copy everything to /app 
COPY . .
# document which port container run
EXPOSE 3000

# execution instruction 
CMD ["npm", "start"]
