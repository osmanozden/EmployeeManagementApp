This project created for Circle by Osman Özden.

### Tech Stack

- JavaSE 17
- PostgresSQL Latest Version
- Maven 3.8.1
- Spring Boot 3.3.3


### Environment setup
Make sure following software is installed on your PC.
* [OpenJDK 17](https://adoptium.net/releases.html?variant=openjdk17&jvmVariant=hotspot) or later.
* [Gradle 7.3](https://gradle.org/install/) or later
* [docker.io 20.x](https://www.docker.com/) or later



### Compile & Build
Most examples are build by top-level maven project.
```
mvn clean

mvn build
```

#Employee Module

### Create Employee
```
curl -X POST 'http://localhost:8080/employee/createEmployee' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "OSMAN",
"position": "Senior Backend Developer",
"email": "ozden.osman@hotmail.com",
"salary": 500
}'
```

### Update Employee
```
curl -X PUT 'http://localhost:8080/employee/updateEmployee?id=55446f38-6e11-4e45-961e-5394945272f1'
' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "muhammed",
"position": "Senior Java Developer",
"email": "ozden@gmail.com",
"salary": 500
}'
```
### Get Employee
```
curl -X GET 'http://localhost:8080/employee/getAllEmployee?id=55446f38-6e11-4e45-961e-5394945272f1'
```

### Get All Employees
```
curl --location 'http://localhost:8080/employee/getAllEmployees
```
### Delete Employee
```
curl -X DELETE 'http://localhost:8080/employee/getAllEmployee?id=55446f38-6e11-4e45-961e-5394945272f1'
```
