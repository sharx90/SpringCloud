package com.hxzy.service.impl;

import com.hxzy.bean.Movie;
import com.hxzy.service.UserToMovieFeignService;
import org.springframework.stereotype.Component;

@Component
public class UserToMovieFeignServiceImpl implements UserToMovieFeignService {

    @Override
    public Movie getNewMovie() {
        Movie movie = new Movie();
        movie.setId(-1);
        movie.setName("无此电影");
        return movie;
    }
}
