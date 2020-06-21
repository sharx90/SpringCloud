package com.hxzy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "MOVIE",path = "/movie-service") // name: 表示服务名
public interface UserToMovieFeignService extends MovieFeignService{


}
