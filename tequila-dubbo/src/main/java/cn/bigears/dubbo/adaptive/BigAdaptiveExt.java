package cn.bigears.dubbo.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * BigAdaptiveExt
 * @author shenyang
 * @date 2019/10/23
 */
@SPI("dubbo")
public interface BigAdaptiveExt {

    /**
     * 输出
     * @param msg msg
     * @param url url
     * @return 输入内容
     */
    @Adaptive(value = "t")
    String echo(String msg, URL url);

}
