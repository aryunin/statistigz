from fastapi import FastAPI
from pydantic import BaseModel
from typing import List
import uvicorn
import os
import joblib
import numpy as np

app = FastAPI()

class RequestDTO(BaseModel):
    answers: List[int]

class ClusterResponseDTO(BaseModel):
    cluster: int

model = joblib.load('model.sav')

def predict(answers: List[int]):
    global model
    model.predict([np.array(answers)])



@app.post("/")
async def root(data: RequestDTO): 
    return ClusterResponseDTO(cluster=predict(data.answers))