# Simulation of Backend Server and REST API with simple JSON file

## Installing JSON Server
- npm install -D json-server

## Create db.json file

    {
      "Todos": [
        {
          "id": 1,
          "todo": "Check Todo"
        },
        {
          "id": 2,
          "todo": "New Todo"
        }
      ]
    }

## Start the JSON server
- json-server --watch db.json
- JSON server will be running on port 3000 (as default)
- We can test and access the URL (of server with 3000 as port) using tools like POSTman
and Insomnia(REST clients that help us run http calls)

## CRUD Operations
- Routing Url's
- [GET] http://localhost:3000/Todos
- [POST] http://localhost:3000/Todos post params:!
- [PUT] http://localhost:3000/Todos post params:!
- [DELETE] http://localhost:3000/Todos/id

## Testing via POSTman
- GET, POST, PUT, DELETE
