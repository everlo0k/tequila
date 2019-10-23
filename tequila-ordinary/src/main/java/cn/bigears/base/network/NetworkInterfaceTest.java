package cn.bigears.base.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * NetworkInterfaceTest
 * @author shenyang
 * @date 2019-05-13
 */
public class NetworkInterfaceTest {

    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
            if (networkInterface == null) {
                System.out.println("No local loopback address.");
            } else {
                System.out.println(networkInterface.getName());
            }
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException");
        } catch (SocketException e) {
            System.out.println("SocketException");
        }

        Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (interfaces.hasMoreElements()) {
            System.out.println(interfaces.nextElement());
        }

    }

}
