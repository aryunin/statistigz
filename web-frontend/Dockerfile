FROM node:20-alpine AS builder
WORKDIR /app
COPY package.json .
RUN npm install
COPY . .
ARG API_HOST
ARG API_PORT
ENV REACT_APP_API_HOST $API_HOST
ENV REACT_APP_API_PORT $API_PORT
RUN npm run build

FROM nginx:1.26.0-alpine AS server
COPY --from=builder ./app/build /usr/share/nginx/html