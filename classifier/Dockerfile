FROM python:3.12
WORKDIR /code
COPY . .
RUN pip install --no-cache-dir --upgrade -r ./requirements.txt
ENTRYPOINT uvicorn app.main:app --host 0.0.0.0 --port $SERVICE_PORT