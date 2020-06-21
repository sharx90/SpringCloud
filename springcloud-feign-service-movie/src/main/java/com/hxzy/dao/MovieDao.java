package com.hxzy.dao;

import com.hxzy.bean.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {

    @Value("${server.port}")
    private String port;

    public Movie getNewMovie(){

        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("战狼2---" + port);

        return movie;
    }

}
