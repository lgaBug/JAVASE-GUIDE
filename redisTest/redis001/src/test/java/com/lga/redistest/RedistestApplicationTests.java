package com.lga.redistest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lga.redistest.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedistestApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void redisTest(){
        System.out.println("redisTemplate = " + redisTemplate);

        System.out.println(redisTemplate.keys("*"));

    }

    @Test
    public void contextLoads() {

        //redisTemplate.opsForValue().set("k2","v2");
        User lga = new User("110", "刘高安");
        //redisTemplate.opsForValue().set("user",lga);
        redisTemplate.opsForHash().put("lga","lga1",lga);
    }


    @Test
    public void test3(){

        Object lga = redisTemplate.opsForHash().get("lga", "lga1");
        System.out.println("lga = " + lga);

        Gson gson = new Gson();
        User user = gson.fromJson(lga.toString(), User.class);
        System.out.println("user = " + user);

    }

}
