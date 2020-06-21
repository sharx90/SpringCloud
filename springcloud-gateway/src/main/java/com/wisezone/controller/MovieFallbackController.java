package com.wisezone.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieFallbackController {


    @RequestMapping("/fallback2")
    public Map fallback(){


        Map map = new HashMap();

        map.put("msg","无此电影");
        map.put("id","-1");

        return map;
    }
}
