Остановить и удалить все:        docker compose -f server.yml --profile cp down -v --rmi all 
Запустить без панели управления: docker compose -f server.yml up -d
Запустить с панелью управления:  docker compose -f server.yml --profile cp up -d