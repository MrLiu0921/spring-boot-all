package top.zzliup.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zzliup.mongodb.TestPojo.A;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class MongodbApplication {

    @Resource
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @RequestMapping("say")
    public String say(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        A a = new A();
        a.setName(name);
        mongoTemplate.insert(a);
        System.out.println("save.......");
        return  mongoTemplate.find(query, A.class).toString();
    }
}
