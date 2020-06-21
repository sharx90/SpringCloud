package com.hxzy.service;

import com.hxzy.bean.Movie;
import com.hxzy.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieDao movieDao;

    public Movie getNewMovie() {
        return movieDao.getNewMovie();
    }

}
