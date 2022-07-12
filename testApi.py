from urllib import response
import requests

persons = [
    {"name": "Anubhav", "age": 28},
    {"name": "Priyansh", "age": 18},
    {"name": "Harsh", "age": 20},
    {"name": "Meitry", "age": 201},
    {"name": "Priyansh", "age": 19},
]

postPerson = "http://localhost:8080/person"

for person in persons:
    response = requests.post(
        url=postPerson, json=person)
    print(response)

# TODO : Get all person by id
uid = [1, 2, 3, 4, 5, 6]
getperson = "http://localhost:8080/person/"

for id in uid:
    response = requests.get(url=getperson + str(id))
    print(response.json)
