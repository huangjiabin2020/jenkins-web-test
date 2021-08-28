package com.example.webjenkinsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
public class StartController {
    @Autowired
    private RedisTemplate<String,Object> template;

    @GetMapping("/")
    public ResponseEntity test(){
        Object ok = template.opsForValue().get("ok");
        if (ObjectUtils.isEmpty(ok)){
            template.opsForValue().set("ok",1);
        }else {
            template.opsForValue().set("ok",((Integer) ok)+1);
        }
        return ResponseEntity.ok("im ok");
    }
}
