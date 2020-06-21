package com.hxzy.service;

import com.hxzy.bean.Movie;
import com.hxzy.service.impl.UserToMovieFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
//@FeignClient(name = "MOVIE", fallback = UserToMovieFeignServiceImpl.class) // name: 表示服务名
@FeignClient(name = "MOVIE",path = "movie",fallbackFactory = UserToMovieFallBackFactory.class)
public interface UserToMovieFeignService {

    @RequestMapping("movie")
    Movie getNewMovie();

}
