package top.zzliup.cachewithredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import top.zzliup.cachewithredis.TestPojo.A;


@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
@RestController
@CacheConfig(cacheNames = "cacheforredis")
public class CacheWithRedisApplication {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(CacheWithRedisApplication.class, args);
    }

    @RequestMapping("/testCache")
    @Cacheable
    public String say(){
        System.out.println("execute opearte mongo");
        return mongoTemplate.find(new Query(), A.class).toString();
    }

    @RequestMapping("clearCache")
    @CacheEvict
    public String clearCache(){
        return "clear Success";
    }

}
