FROM node:20-alpine AS builder
WORKDIR /app
COPY package.json .
RUN npm install
COPY . .
ENV REACT_APP_API_HOST localhost
ENV REACT_APP_API_PORT 80
ENV REACT_APP_API_PREFIX api
RUN npm run build

FROM nginx:1.26.0-alpine AS server
COPY --from=builder ./app/build /usr/share/nginx/html
COPY --from=builder ./app/default.conf.template /etc/nginx/conf.d
ENTRYPOINT envsubst < /etc/nginx/conf.d/default.conf.template > /etc/nginx/conf.d/default.conf && exec nginx -g 'daemon off;'