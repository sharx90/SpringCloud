package com.hxzy.service.impl;

import com.hxzy.bean.Movie;
import com.hxzy.service.UserToMovieFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserToMovieFallBackFactory implements FallbackFactory<UserToMovieFeignService> {

    @Override
    public UserToMovieFeignService create(Throwable throwable) {

        return new UserToMovieFeignService() {
            @Override
            public Movie getNewMovie() {
                Movie movie = new Movie();
                movie.setId(-1);
                movie.setName("无此电影2");
                return movie;
            }
        };

    }
}
