package bigears.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * RedisCLusterConnect
 *
 * @author shenyang
 */
public class RedisClusterConnect {

    public static void main(String[] args) {

        Set<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("10.1.1.105", 7000));
        hostAndPorts.add(new HostAndPort("10.1.1.105", 7001));
        hostAndPorts.add(new HostAndPort("10.1.1.105", 7002));
        hostAndPorts.add(new HostAndPort("10.1.1.105", 7003));
        hostAndPorts.add(new HostAndPort("10.1.1.105", 7004));
        hostAndPorts.add(new HostAndPort("10.1.1.105", 7005));
        JedisCluster jedisCluster = new JedisCluster(hostAndPorts, 5000, 5000, 1, "bid@link", new GenericObjectPoolConfig());
        jedisCluster.set("name", "tequila");
        System.out.println(jedisCluster.get("name"));
    }

}
