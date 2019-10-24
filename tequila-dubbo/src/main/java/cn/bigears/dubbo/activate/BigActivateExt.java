package cn.bigears.dubbo.activate;

import org.apache.dubbo.common.extension.SPI;

/**
 * BigActivateExt
 * @author shenyang
 * @date 2019/10/24
 */
@SPI
public interface BigActivateExt {

    /**
     * 输出
     * @param msg msg
     * @return 输出内容
     */
    String echo(String msg);
}
