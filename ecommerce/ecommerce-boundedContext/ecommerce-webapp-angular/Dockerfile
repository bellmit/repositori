# Multi-stage
# 1) Node image for building frontend assets
# 2) nginx stage to serve frontend assets

# Name the node stage "node"
FROM node:10-alpine as node

COPY package.json package-lock.json ./


# RUN npm i npm@latest -g && mkdir /app && cp -R ./node_modules ./app
#RUN npm i npm@latest -g

#RUN npm install && mkdir /usr/src/app && mv ./node_modules ./usr/src/app

WORKDIR /usr/src/app

# Copy all files from current directory to working dir in image
COPY . .

# install node modules and build assets
#RUN npm i && npm run build


# ----------------------------------
# Prepare production environment
# nginx state for serving content
FROM nginx:alpine
# ----------------------------------

# Clean nginx
# Remove default nginx static assets
RUN rm -rf /usr/share/nginx/html/*

COPY ./nginx.conf  /etc/nginx/conf.d/default.conf

# copy our build files from the stage "node"
COPY --from=node /usr/src/app/dist /usr/share/nginx/html

# Set the permission to allow nginx to run and provide css files
RUN chown root /usr/share/nginx/html/*
RUN chmod 755 /usr/share/nginx/html/*


# Containers run nginx with global directives and daemon off
CMD ["nginx", "-g", "daemon off;"]


