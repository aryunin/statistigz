FROM node:20-alpine AS builder
WORKDIR /app
COPY package.json .
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.26.0-alpine AS server
COPY --from=builder ./app/build /usr/share/nginx/html
COPY --from=builder ./app/default.conf.template /etc/nginx/conf.d
CMD envsubst < /etc/nginx/conf.d/default.conf.template > /etc/nginx/conf.d/default.conf && nginx -g 'daemon off;'