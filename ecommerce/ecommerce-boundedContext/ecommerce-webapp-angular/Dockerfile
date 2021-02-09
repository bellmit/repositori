FROM node:8.11.2-alpine as node

COPY package.json package-lock.json ./


# RUN npm i npm@latest -g && mkdir /app && cp -R ./node_modules ./app
#RUN npm i npm@latest -g

#RUN npm install -g @angular/cli

WORKDIR /usr/src/app

COPY . .

#RUN npm install

#RUN npm run build -- --outputPath=./dist/


# ----------------------------------
# Prepare production environment
FROM nginx:alpine
# ----------------------------------

FROM nginx:1.13.3-alpine

# Clean nginx
RUN rm -rf /usr/share/nginx/html/*

COPY ./nginx.conf  /etc/nginx/conf.d/default.conf

# copy our build files from the stage "node"
COPY --from=node /usr/src/app/dist /usr/share/nginx/html


# Set the permission to allow nginx to run and provide css files
RUN chown root /usr/share/nginx/html/*
RUN chmod 755 /usr/share/nginx/html/*

# Start the nginx server
CMD ["nginx", "-g", "daemon off;"]