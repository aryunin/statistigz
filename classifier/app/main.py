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

model = joblib.load('kmeans.sav')
pca = joblib.load('pca.sav')
slice = np.array([5,7,8,9,10,12,13,14,15,16,17]) - 1
maximums = np.array([4,4,4,4,4,4,4,4,4,4,2], dtype=np.float64)

def predict(answers: List[int]):
    global model
    global pca
    global slice
    global maximums
    answers = np.array(answers, dtype=np.float64)[slice]
    answers /= maximums
    answers = pca.transform((answers,))
    return model.predict(answers)[0]



@app.post("/")
async def root(data: RequestDTO):
    cluster = predict(data.answers)
    response = ClusterResponseDTO(cluster=cluster)
    return response