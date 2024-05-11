PowerShell:
docker build -t front --build-arg REACT_APP_API_HOST=localhost --build-arg REACT_APP_API_PORT=8081 --build-arg REACT_APP_API_PREFIX=api . ; docker run -d -p 8080:80 -t --name front front

Cmd/Bash:
docker build -t front --build-arg REACT_APP_API_HOST=localhost --build-arg REACT_APP_API_PORT=8081 --build-arg REACT_APP_API_PREFIX=api . && docker run -d -p 8080:80 -t --name front front
