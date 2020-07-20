# Clean Architecture Example

Clean Architecture example using Java wihtout any framework, a Spring Boot Application and VertX appliction.

## Build

```
mvn clean install
```

## Run

### Java without framework
```
cd application/manual-app/

mvn exec:java -Dexec.mainClass="com.gogo.powerrangers.Main" -Dexec.args=<ARGS>

Example:
mvn exec:java -Dexec.mainClass="com.gogo.powerrangers.Main" -Dexec.args="Guilherme guilherme.garcia86@gmail.com 34 Persistência"
```

### Spring Boot Application
```
cd application/spring-boot

mvn spring-boot:run
```

### VertX Application
```
cd application/vertx

mvn clean compile vertx:run
```