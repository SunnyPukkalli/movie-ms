package com.ms.movieinfoservice.resource;


import com.ms.movieinfoservice.model.Movie;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movies/")
public class MovieResource {

    @GetMapping("{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){

        String movieName = RandomStringUtils.randomAlphabetic(5);
        String description = RandomStringUtils.randomAlphabetic(10);

        return new Movie(movieId,movieName,description);
    }

}
