package cn.bigears.redis;

import java.util.Set;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * RedissonConnect
 *
 * @author shenyang
 */
public class RedissonConnect {


    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://10.1.1.105:6379").setPassword("bid@link");
        // 使用Redisson客户端，往redis存一个set
        RedissonClient redissonClient = Redisson.create(config);
        Set companySet = redissonClient.getSet("company_set");
        companySet.add("bidlink");
    }

}
