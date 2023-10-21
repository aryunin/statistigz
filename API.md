# API specification

## GET api/regions 

список всех регионов, отсортированный по убыванию *score* (общий балл по всем критериям) 

### ok: \[region\]
```
[
  {
    "id": int, 
    "name": string,
    "score": int,
    "achievements": [
      {
        "projection": projection (without criteria),
        "score": int
      }
    ]
  }
]
```

## GET api/regions?projection={int}

список всех регионов, отсортированный убыванию *score* (балл по определенному комплексному критерию)

### ok: \[region\]
```
[
  {
    "id": int,
    "name": string,
    "score": int,
    "achievements": [
      {
        "projection": projection (without criteria),
        "score": int
      }
    ]
  }
]
```
### projection not found: error
```
{
  "code": int,
  "message": string
}
```

## GET api/projections

список всех комплексных критериев с информацией об идентификаторах, отсортированный по названию КК в алфавитном порядке

### ok: \[projection\]
```
[
  {
    "id": int,
    "name": string,
    "criteria": [
      {
        "id": int,
        "name": string
      }
    ]
  }
]
```

