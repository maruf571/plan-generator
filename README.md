# Plan Generator
This project is a simple loan plan generator. 

## Tech spec
- java 17 
- spring boot 3.*
- maven

## Requirement
- Java 17
- Maven 3.5 or greater version

####  To run on the local env
```
git clone https://github.com/maruf571/plan-generator.git
cd plan-generator
mvn spring-boot:run
```

## How to run test 
- Run unit test only
```
$ mvn test
```

build
## Docker
```
$ docker build -t lendico/plan-generator .
```
run 
```
$ docker run -p 7070:8080 -t lendico/plan-generator
```

## API
Sample request
```
POST http://localhost:7070/generate-plan
{
    "loanAmount": "5000",
    "nominalRate": "5.0",
    "duration": 24,
    "startDate": "2018-01-01T00:00:01Z"
}

```
Response
```
{
  "planList": [
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-01-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 5000,
      "interest": 20.83,
      "principal": 198.53,
      "remainingOutstandingPrincipal": 4801.47
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-02-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 4801.47,
      "interest": 20.01,
      "principal": 199.35,
      "remainingOutstandingPrincipal": 4602.12
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-03-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 4602.12,
      "interest": 19.18,
      "principal": 200.18,
      "remainingOutstandingPrincipal": 4401.94
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-03-31T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 4401.94,
      "interest": 18.34,
      "principal": 201.02,
      "remainingOutstandingPrincipal": 4200.92
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-04-30T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 4200.92,
      "interest": 17.50,
      "principal": 201.86,
      "remainingOutstandingPrincipal": 3999.06
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-05-31T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 3999.06,
      "interest": 16.66,
      "principal": 202.70,
      "remainingOutstandingPrincipal": 3796.36
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-06-30T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 3796.36,
      "interest": 15.82,
      "principal": 203.54,
      "remainingOutstandingPrincipal": 3592.82
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-07-31T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 3592.82,
      "interest": 14.97,
      "principal": 204.39,
      "remainingOutstandingPrincipal": 3388.43
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-08-31T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 3388.43,
      "interest": 14.12,
      "principal": 205.24,
      "remainingOutstandingPrincipal": 3183.19
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2018-09-30T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 3183.19,
      "interest": 13.26,
      "principal": 206.10,
      "remainingOutstandingPrincipal": 2977.09
    },
    {
      "borrowerPaymentAmount": 219.35,
      "date": "2018-11-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 2977.09,
      "interest": 12.40,
      "principal": 206.95,
      "remainingOutstandingPrincipal": 2770.14
    },
    {
      "borrowerPaymentAmount": 219.35,
      "date": "2018-12-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 2770.14,
      "interest": 11.54,
      "principal": 207.81,
      "remainingOutstandingPrincipal": 2562.33
    },
    {
      "borrowerPaymentAmount": 219.35,
      "date": "2019-01-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 2562.33,
      "interest": 10.68,
      "principal": 208.67,
      "remainingOutstandingPrincipal": 2353.66
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2019-02-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 2353.66,
      "interest": 9.81,
      "principal": 209.55,
      "remainingOutstandingPrincipal": 2144.11
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2019-03-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 2144.11,
      "interest": 8.93,
      "principal": 210.43,
      "remainingOutstandingPrincipal": 1933.68
    },
    {
      "borrowerPaymentAmount": 219.35,
      "date": "2019-03-31T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 1933.68,
      "interest": 8.06,
      "principal": 211.29,
      "remainingOutstandingPrincipal": 1722.39
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2019-04-30T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 1722.39,
      "interest": 7.18,
      "principal": 212.18,
      "remainingOutstandingPrincipal": 1510.21
    },
    {
      "borrowerPaymentAmount": 219.35,
      "date": "2019-05-31T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 1510.21,
      "interest": 6.29,
      "principal": 213.06,
      "remainingOutstandingPrincipal": 1297.15
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2019-06-30T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 1297.15,
      "interest": 5.40,
      "principal": 213.96,
      "remainingOutstandingPrincipal": 1083.19
    },
    {
      "borrowerPaymentAmount": 219.35,
      "date": "2019-07-31T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 1083.19,
      "interest": 4.51,
      "principal": 214.84,
      "remainingOutstandingPrincipal": 868.35
    },
    {
      "borrowerPaymentAmount": 219.35,
      "date": "2019-08-31T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 868.35,
      "interest": 3.62,
      "principal": 215.73,
      "remainingOutstandingPrincipal": 652.62
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2019-09-30T23:00:01.000+00:00",
      "initialOutstandingPrincipal": 652.62,
      "interest": 2.72,
      "principal": 216.64,
      "remainingOutstandingPrincipal": 435.98
    },
    {
      "borrowerPaymentAmount": 219.35,
      "date": "2019-11-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 435.98,
      "interest": 1.82,
      "principal": 217.53,
      "remainingOutstandingPrincipal": 218.45
    },
    {
      "borrowerPaymentAmount": 219.36,
      "date": "2019-12-01T00:00:01.000+00:00",
      "initialOutstandingPrincipal": 218.45,
      "interest": 0.91,
      "principal": 218.45,
      "remainingOutstandingPrincipal": 0.00
    }
  ]
}
```
