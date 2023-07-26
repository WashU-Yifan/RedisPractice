package com.EthanW;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class TestJedis {
    private Jedis jedis;

    @BeforeEach
    void setJedis() {
        jedis = new Jedis("127.0.0.1", 6379);
        jedis.select(0);
    }

    @Test
    void testName() {
        jedis.lpush("a", "a");
        String res = jedis.lpop("a");
        assert(res.equals("a"));
        System.out.println("okay");

    }

    @AfterEach
    void closeJedis() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
