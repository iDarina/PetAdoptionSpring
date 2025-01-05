# Endpoints: 

GET /pets: Get all pets

GET /pets/{id}: Get pet by id

POST /pets: Create pet
```
{  
  "name": "Max",  
  "breed": "Golden Retriever",  
  "age": "2"  
}
```

PUT /pets/{id}: Update pet
```
{  
  "id": 1,  
  "name": "Max",  
  "breed": "Golden Retriever",  
  "age": "3"  
}
```

DELETE /pets/{id}: Delete pet

GET /pets/search: Search pets by name

GET /adoptions: Get all adoptions

GET /adoptions/{id}: Get adoption by id

POST /adoptions: Create adoption
```
{  
  "adopterName": "John Doe",  
  "adopterEmail": "john.doe@example.com",  
  "pet": {  
   "id": 1  
  }  
}
```

PUT /adoptions/{id}: Update adoption
```
{  
  "id": 1,  
  "adopterName": "Jane Doe",  
  "adopterEmail": "jane.doe@example.com",  
  "pet": {  
   "id": 1  
  }  
}
```

DELETE /adoptions/{id}: Delete adoption

GET /adoptions/search?name={name}: Search adoptions by adopter name

GET /shelters: Get all shelters

GET /shelters/{id}: Get shelter by id

POST /shelters: Create shelter
```
{  
  "name": "Animal Shelter",  
  "address": "123 Main St"  
}
```

PUT /shelters/{id}: Update shelter
```
{  
  "id": 1,  
  "name": "Animal Shelter",  
  "address": "456 Main St"  
}
```

DELETE /shelters/{id}: Delete shelter

GET /shelters/search?name={name}: Search shelters by name
