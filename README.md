#CityConnections

This Spring boot app features two endpoints:
- /healthcheck - application is up and ready
- /connected - used to check if two cities are connected
   
   
ex:
```
http://localhost:8080/connections?origin=Boston&destination=New%20York
```

##Prequisites
- JDK 1.8.0 or above (Developed on openjdk version "1.8.0_222")
- Gradle

###Running the app

Execute the command:

```gradle bootRun```

The app should start on http://localhost:8080


###Running the tests
Execute the command: 

```gradle test```

###Accessing Swagger Documentation
- Browse to http://localhost:8080/swagger-ui.html


