package com.hxzy.service;

import com.hxzy.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public interface UserFeignService {

    @RequestMapping("byMovie")
    Map getBuyMovie(Integer id);

    @RequestMapping("user")
    User getUser(Integer id);

}
