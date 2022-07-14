from urllib import response
import json
import requests

persons = [
    {"name": "Thor", "age": 1000},
    {"name": "Priyansh", "age": 18},
    {"name": "Odin", "age": 20},
    {"name": "Mjolnir", "age": 100000},
    {"name": "Priyansh", "age": 19},

]

postPerson = "http://localhost:8080/person"
getperson = "http://localhost:8080/person/"
getId = [1, 2, 3, 4, 5, 6]


def postPersons():
    for person in persons:
        response = requests.post(url=postPerson, json=person)
        print(response)


def getPersons():
    try:
        for id in getId:
            response = requests.get(url=getperson + str(id))
            if(response.status_code >= 400):
                print("Not Found")
            else:
                print(response.json())
    except requests.JSONDecodeError:
        print("Not found")


postPersons()
getPersons()
