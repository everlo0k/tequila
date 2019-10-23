package cn.bigears.dubbo.adaptive;

import org.apache.dubbo.common.URL;

/**
 * BigDubboAdaptiveExt
 * @author shenyang
 * @date 2019/10/23
 */
public class BigDubboAdaptiveExt implements BigAdaptiveExt {
    /**
     * 输出
     * @param msg msg
     * @param url url
     * @return 输入内容
     */
    @Override
    public String echo(String msg, URL url) {
        return "dubbo";
    }
}
