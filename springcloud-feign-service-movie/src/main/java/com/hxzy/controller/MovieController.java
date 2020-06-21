package com.hxzy.controller;


import com.hxzy.bean.Movie;
import com.hxzy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("movie")
    public Movie getNewMovie(){
        return  movieService.getNewMovie();
    }

}
