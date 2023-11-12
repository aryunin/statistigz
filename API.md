# API specification

## DTO
### Criteria
```
{
  "id": long,
  "name": string
}
```
### Region
```
{
  "id": long,
  "name": string,
  "description": string
}
```
### Projection
```
{
  "id": long,
  "name": string
} 
```
### ProjectionCriteria
```
{
  "id": long,
  "name": string,
  "criteria": [ Criteria ]
}
```
### RegionProjection
```
{
  "projection": Projection,
  "score": double (precision = 2),
  "place": int
}
```
### Achievement
```
{
  "projection": Projection
}
```
### RegionProjections
```
{
  "id": long,
  "name": string,
  "description": string,
  "projections": [ RegionProjection ],
  "achievements": [ Achievement ]
}
```
### RegionScore
```
{
  "id": long,
  "name": string,
  "score": double (precision = 2),
  "achievements": [ Achievement ]
}
```
### ErrorResponse
```
{
  "code": int,
  "message": string
}
```
---
## Endpoints
### GET api/regions 

**params**: 
* *projectionId* (optional, id of projection or else common projection)

**description**: список всех регионов в проекции (если указана, иначе общаяя проекция), отсортированных по убыванию *score*

**ok**:
```
[ RegionScore ]
```

**projection not found** (code 1, status 404):
```
ErrorResponse
```

### GET api/regions/{id}

**description**: регион с id=*id* со всеми проекциями и их *score*, отсортированными по убыванию *score* 

**ok**:
```
RegionProjections
```

**region not found** (code 1, status 404):
```
ErrorResponse
```

### GET api/regions/search

**params**: 
* *name* (required, part of region name)

**description**: поиск региона по имени. В результате список регионов без какой либо лишней информации, отсортированный по возрастанию в алфавитном порядке

**ok**:
```
[ Region ]
```

**name didn't provide** (code 2, status 400):
```
ErrorResponse
```

### GET api/projections

**description**: список всех проекций с включенными в них критериями, отсортированный по названию проекций в алфавитном порядке. Критерии внутри также отсортированы по возрастанию в алфавитном порядке

**ok**:
```
[ ProjectionCriteria ]
```
