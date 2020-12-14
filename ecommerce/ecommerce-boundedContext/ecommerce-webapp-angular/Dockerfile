FROM node:8.11.2-alpine as node

COPY package.json package-lock.json ./

# RUN npm i npm@latest -g && mkdir /app && cp -R ./node_modules ./app
RUN npm i npm@latest -g

WORKDIR /usr/src/app

COPY . .

RUN npm install

#RUN npm run build -- --outputPath=./dist/


FROM nginx:1.13.3-alpine

RUN rm -rf /usr/share/nginx/html/*

COPY ./nginx.conf  /etc/nginx/conf.d/default.conf

COPY --from=node /usr/src/app/dist /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]