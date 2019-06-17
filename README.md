# spring-graphql-api [![Build Status](https://travis-ci.com/DivitGitHub/spring-graphql-api.svg?branch=master)](https://travis-ci.com/DivitGitHub/spring-graphql-api)

This is a Music GraphQL-API Spring boot application with CRUD functionality with h2 serving as a database and jooq for our database persistence layer.

## What you'll need
Java 11

Maven 3.5.3+

lombok (https://projectlombok.org/ Remember to restart your IDE if you're installing lombok into your IDE)


## Start
Build:
```
mvn install
```
### Start server:
#### You can either:
Run the Application class in ```src/main/java/com.divitngoc.application``` as Java Application.
#### Or
Use command:
```
yourPath\divitngoc-marvel-api\divitngoc-marvel-server\target java -jar marvel-server-spring-boot.jar
```

### RESTFul API endpoints
```
GET /music/songs
```

### GraphQL endpoints
```
GET /graphql/schema.json
```
```
POST /graphql
```
```
Example 1:
POST /graphql
{
  "query": "{fetchAllSongs { title publishedDate } }"
}
```
```
Example 2:
POST /graphql
{
  "query": "{fetchSongsByArtistId(artistId: 1) { id title publishedDate artist{id firstName lastName} } }"
}
```
## Swagger
Coming soon.
