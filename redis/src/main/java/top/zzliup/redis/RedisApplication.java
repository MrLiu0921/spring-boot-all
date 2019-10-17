package top.zzliup.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.HashMap;

@SpringBootApplication
@RestController
public class RedisApplication {

    @Resource
    private JedisPoolConfig jedisPoolConfig;

    @Resource
    private JedisPool jedisPool;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig getJedisPoolConfig(){
        return new JedisPoolConfig();
    }

    @Bean
    public JedisPool JedisPool(@Value("${spring.redis.host}") String host){
        return new JedisPool(host);
    }

    @RequestMapping("/say")
    public String say(String key,String value){
        Jedis jedis = jedisPool.getResource();
        boolean result = jedis.exists(key);
        System.out.println(result);
        jedis.set(key,value);
        return  jedis.get(key);

    }

}
