# API specification

## GET api/regions 

список всех регионов, отсортированный по *score* (общий балл по всем критериям) 

### ok: \[region\]
```
[
  {
    "id": int, 
    "name": string,
    "score": int,
    "achievements": [
      {
        "projection": projection
        "score": int
      }
    ]
  }
]
```

## GET api/regions?projection={int}

список всех регионов, отсортированный *score* (балл по определенному комплексному критерию_

### ok: \[region\]
```
[
  {
    "id": "int",
    "name": "string",
    "score": "int",
    "achievements": [
      {
        "projection": "projection",
        "score": "int"
      }
    ]
  }
]
```
### projection not found: error
```
{
  "code": "int",
  "message": "string"
}
```

## GET api/projections

список всех комплексных критериев с информацией об идентификаторах

### ok: \[projection\]
```
[
  {
    "id": "int",
    "name": "string",
    "criteria": [
      {
        "id": "int",
        "name": "string"
      }
    ]
  }
]
```

