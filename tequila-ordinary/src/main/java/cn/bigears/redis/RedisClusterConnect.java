package cn.bigears.redis;

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
        hostAndPorts.add(new HostAndPort("10.0.0.126", 6379));
        hostAndPorts.add(new HostAndPort("10.0.0.126", 6380));
        hostAndPorts.add(new HostAndPort("10.0.0.127", 6379));
        hostAndPorts.add(new HostAndPort("10.0.0.127", 6380));
        hostAndPorts.add(new HostAndPort("10.0.2.42", 6379));
        hostAndPorts.add(new HostAndPort("10.0.2.42", 6380));
        JedisCluster jedisCluster = new JedisCluster(hostAndPorts, 50000, 50000, 1, "bid@link", new GenericObjectPoolConfig());
        jedisCluster.setex("name1", 30,"tequila1");
        System.out.println(jedisCluster.get("name1"));


        Set<HostAndPort> hostAndPorts1 = new HashSet<>();
        hostAndPorts1.add(new HostAndPort("10.4.0.163", 6379));
        hostAndPorts1.add(new HostAndPort("10.4.0.163", 6380));
        hostAndPorts1.add(new HostAndPort("10.4.0.164", 6379));
        hostAndPorts1.add(new HostAndPort("10.4.0.164", 6380));
        hostAndPorts1.add(new HostAndPort("10.4.0.165", 6379));
        hostAndPorts1.add(new HostAndPort("10.4.0.165", 6380));
        JedisCluster jedisCluster1 = new JedisCluster(hostAndPorts1, 50000, 100000, 1, "bid@link", new GenericObjectPoolConfig());
        jedisCluster1.setex("name1", 30,"tequila1");
        System.out.println(jedisCluster1.get("name1"));


    }

}
