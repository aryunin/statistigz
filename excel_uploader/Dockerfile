FROM python:3.11.6 AS builder
COPY requirements.txt .
RUN pip install --user -r requirements.txt

FROM python:3.11.6-slim
WORKDIR /code
COPY --from=builder /root/.local /root/.local
COPY . .
ENV PATH=/root/.local:$PATH