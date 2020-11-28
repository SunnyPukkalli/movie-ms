# movie-ms

### *Movie Microservice*

- Movie Catalog Service
  - URL Exposed : `http://localhost:8080/catalog/1` [ Returns Movie Information and Ratings based on User Information passed ]
  - Call Ratings Service to fetch movie ratings given by user
  - Call Movie Info Service to fetch movie details based on movie information retrieved from ratings service

- Ratings Data Service
  - Return Movie Id and Rating based on movieId `http://localhost:8082/ratings/{movieID}`
  - Return List of Movie Id and Rating based on userId `http://localhost:8082/ratings/users/{userId}`

- Movie Info Service
  - Return Random Movie Details based on movieId `http://localhost:8081/movies/{movieId}`
