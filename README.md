# Plan Generator

## Tech spec
- java 1.8 
- spring boot 2.*
- maven

## DEV setup
To run  this project in local environment, you need to have the following 
- Java 8 or greater version
- Maven 3.5 or greater version

####  To run on the local env
```
$ mvn spring-boot:run
```
 

## How to run test 
On this project, there are  unit and integration test. Integration test is time consuming test. 
I am using `it` profile for integration test. 
It is possible to run unit and integration alone. Please follow the instruction bellow.
 Maven lifecycle may help to understand the test and verify phase.   

- Run unit test only
```
$ mvn test
```

- Run  integration test only
```
$ mvn integration-test -DskipTests
```

- Run both unit & integration test
```
$ mvn verify 
```

## Docker
build
```$xslt
$ docker build -t lendico/plan-generator .
```
run 
```$xslt
$ docker run -p 7070:8080 -t lendico/plan-generator
```

Hit api 
```
POST http://localhost:7070/generate-plan
{
    "loanAmount": "5000",
    "nominalRate": "5.0",
    "duration": 24,
    "startDate": "2018-01-01T00:00:01Z"
}

```

