package cn.bigears.base.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddressTest
 * @author shenyang
 * @date 2019-03-28
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
        System.out.println(inetAddress.getHostName());

        inetAddress = InetAddress.getByName("220.181.111.37");
        System.out.println(inetAddress);
        System.out.println(inetAddress.getHostName());

        inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);

        inetAddress = InetAddress.getByName("208.201.239.100");
        System.out.println(inetAddress.getCanonicalHostName());



    }

}
