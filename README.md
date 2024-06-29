[-] With inspiration from

https://github.com/codedecode25/Microservices_vaccination_citizen

# Endpoints

### Eureka Server

http://localhost:8761

### citizen-service

http://localhost:8081

### crud:

- Get citizens by vaccination id
  http://localhost:8081/citizen/id/{id}

- Add citizen
  http://localhost:8081/citizen/add
  Resulst:

`{
  "id": 1,
  "name": "Citizen name",
  "vaccinationCenterId": 1
}`

### vaccination-center

http://localhost:8082

### crud:

Get vaccination center:
http://localhost:8082/vaccination/center/id/{id}
Results:

`"center": {
        "id": 1,
        "centerName": "Location 1",
        "address": "123 address place"
    },
    "citizens": [
        {
            "id": 1,
            "name": "John Doe",
            "vaccinationCenterId": 1
        },
        {
            "id": 2,
            "name": "Jane Doe2",
            "vaccinationCenterId": 1
        }
    ]
}`
