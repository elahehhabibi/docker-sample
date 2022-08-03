Docker Example -One
=======================

Spring boot application- hello world project
-----------------------

##build  application ##
###  Maven
```
$ mvn spring-boot:run
```
###  Docker
```
$ docker build . -t sampleapp
$ docker run -p 8095:8095 -d sampleapp
```

##  API

###/helloworld

```
$ curl localhost:8099/helloworld
Hello Stranger
```

###/helloworld?name={name}

```
$ curl localhost:8099/helloworld?name=nameTest
Hello nameTest
```

###/author

```
$ curl localhost:8099/author
Elaheh Habibi
```


