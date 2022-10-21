package com.example.jebal;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class HelloController {
    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/data")
    public ResponseEntity<String> setRedisData(
            @RequestBody(required = true) Map<String,String> map) throws Exception{

        redisTemplate.opsForValue().set(map.get("key"), map.get("value"));

        return new ResponseEntity<>("정상 등록", HttpStatus.CREATED);
    }

    @GetMapping("/data")
    public ResponseEntity<String> getRedisData(
            @RequestParam(required = true) String key){

        return new ResponseEntity<>(redisTemplate.opsForValue().get(key), HttpStatus.OK);

    }

}