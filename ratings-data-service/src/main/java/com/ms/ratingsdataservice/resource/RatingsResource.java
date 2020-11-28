package com.ms.ratingsdataservice.resource;


import com.ms.ratingsdataservice.model.Rating;
import com.ms.ratingsdataservice.model.UserRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    Logger logger = LoggerFactory.getLogger(RatingsResource.class);

    public Random getRandom() {
        return new Random();
    }

    @Autowired
    public void setRandom() {
        this.random = getRandom();
    }

    private Random random;

    @GetMapping(value = "/{movieId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Rating getRating(@PathVariable("movieId")  int movieId){
        return new Rating(movieId,random.nextInt());
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId")  String userId){

        /*
         * 1. Generate Random Number from 1-10
         * 2. Iterate and generate random data in loop
         * */
        int loop = random.nextInt(15);
        if(loop < 2){
            loop = 2;
        }

        logger.info("Generated loop number is : "+loop);

        List<Rating> ratings = new ArrayList<>();

        IntStream.rangeClosed(2,loop).forEach(
                value -> ratings.add(new Rating(value,random.nextInt(5)))
        );

        logger.info("Generated ratings are : "+ratings);

        UserRating userRatings =  new UserRating();
        userRatings.setRatings(ratings);

        return userRatings;
    }
}
