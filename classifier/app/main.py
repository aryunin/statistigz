from fastapi import FastAPI
from pydantic import BaseModel
from typing import List
import uvicorn
import os

app = FastAPI()

class RequestDTO(BaseModel):
    answers: List[int]

class ClusterResponseDTO(BaseModel):
    cluster: int

@app.post(os.environ.get("SERVICE_PATH", "/"))
async def root(data: RequestDTO): 
    return ClusterResponseDTO(cluster=1)