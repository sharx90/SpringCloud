package com.hxzy.service;

import com.hxzy.bean.Movie;
import org.springframework.web.bind.annotation.RequestMapping;


public interface MovieFeignService {

    @RequestMapping("movie")
    Movie getNewMovie();

}
