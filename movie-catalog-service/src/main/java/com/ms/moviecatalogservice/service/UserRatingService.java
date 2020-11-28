package com.ms.moviecatalogservice.service;

import com.ms.moviecatalogservice.model.UserRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRatingService {

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(UserRatingService.class);

    public UserRating getUserRating(@PathVariable("userId") int userId) {

        logger.info("Performing REST API Call to ratings-data to URL :- " +getUrl());
        return restTemplate.getForObject(getUrl()+userId, UserRating.class);
    }


    public String getUrl(){
        return "http://ratings-data/ratings/users/";
    }

}
