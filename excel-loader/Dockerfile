FROM python:3.11.6
WORKDIR /code
COPY . .
RUN pip install --no-cache-dir --upgrade -r ./requirements.txt
RUN chmod +x ./wait-for-it.sh
ENTRYPOINT ./wait-for-it.sh -s -t 120 -h $PREV_SERVICE_HOST -p $PREV_SERVICE_PORT -- python -u uploader.py