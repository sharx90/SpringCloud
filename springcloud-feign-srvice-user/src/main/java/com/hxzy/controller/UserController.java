package com.hxzy.controller;


import com.hxzy.bean.Movie;
import com.hxzy.bean.User;
import com.hxzy.service.UserService;
import com.hxzy.service.UserToMovieFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public User getUser(Integer id){
        User user = userService.getUser(id);
        return user;
    }

    @Value("${ser.movie}")
    String movie;

    @RequestMapping("byMovie")
    public Map getBuyMovie(Integer id){

        User user = userService.getUser(id);

        // 查询电影
        String resp = restTemplate.getForObject(movie+"/movie-service/movie", String.class);

        Map map = new HashMap();

        map.put("user",user);
        map.put("movie",resp);

        return map;
    }

    @Autowired
    UserToMovieFeignService userToMovieFeignService;

    @RequestMapping("byMovie2")
    public Map getBuyMovie2(Integer id){

        User user = userService.getUser(id);

        // 查询电影
        Movie movie = userToMovieFeignService.getNewMovie();

        Map map = new HashMap();

        map.put("user",user);
        map.put("movie",movie);

       return map;
    }

}
