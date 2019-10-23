package bigears.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.SetArgs;

/**
 * LettuceRedisClient
 * @author shenyang
 * @date 2019-08-13
 */
public class LettuceRedisClient {

    public static void main(String[] args) {

        //10.1.1.72
        RedisURI redisUri = RedisURI.Builder.redis("10.0.0.11")
                .withPort(6379)
//                .withPassword("bid6link")
                .build();
        RedisClient client = RedisClient.create(redisUri);

        System.out.println(client.connect().sync().get("1"));

        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        String result = client.connect().sync().set("name", "throwable", setArgs);
        System.out.println(result);

    }

}
