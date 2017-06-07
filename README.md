# How to run the backend?

By default, the backend api listens for port `8080`.

#### Before running the backend
1. Apply for [Algolia](https://www.algolia.com) account and get your `applicationId` and `apiKey`
2. Apply for [Auth0](https://auth0.com) account, create API and obtain your `issuer` and `audience`
3. Create `application.yml` file (see example below) under `src/test/resources` and replace placeholders with the actual values:
```
spring:
  devtools:
    livereload:
      enabled: false
algolia:
  appId: <yourAppId>
  apiKey: <yourApiKey>
auth0:
  issuer: <issuer>
  apiAudience: <audience>
```


#### Running in Dev mode
> under `src/test/java` run `DevApplicationBootstrap`
 
##### Accessing H2 DB
H2 database console is available at `/h2-console`. The JDBC connection string is `jdbc:h2:mem:testdb`. 
 
#### Running in Production mode
> under `src/main/java` run `ApplicationBootstrap`

> ./gradlew bootRun

# Development guidelines
We use IDEA for development.


