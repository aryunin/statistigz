Остановить и удалить бэкэнд:     docker compose -f server.yml --profile cp down --rmi all 
Запустить без панели управления: docker compose -f server.yml up -d
Запустить с панелью управления:  docker compose -f server.yml --profile cp up -d
Остановить и удалить фронтэнд:   docker compose -f frontend.yml down --rmi all 
Запустить фронтэнд:				 docker compose -f frontend.yml up -d