package com.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    private Logger logger = LoggerFactory.getLogger(RedisTest.class);
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    /**
     * opsForValue： 对应 String（字符串）
     * opsForZSet： 对应 ZSet（有序集合）
     * opsForHash： 对应 Hash（哈希）
     * opsForList： 对应 List（列表）
     * opsForSet： 对应 Set（集合）
     * opsForGeo： 对应 GEO（地理位置）
     * http://www.manongjc.com/article/103746.html
     */
    @Test
    public void test() throws InterruptedException {
        String key = "user:1";
        redisTemplate.opsForValue().set("a","bbb");
        // 存储结果为"abc"，命令行对应的结果为 "\"abc\"" ，但java控制台能正确输出
        System.err.println(redisTemplate.opsForValue().get("a"));

        // 虽然这里能够正常输出，但是在桌面客户端看的时候存储的数据为乱码
        redisTemplate.opsForHash().put("student","stu","xiaoming");
        System.err.println(redisTemplate.opsForHash().get("student","stu"));
    }
}
