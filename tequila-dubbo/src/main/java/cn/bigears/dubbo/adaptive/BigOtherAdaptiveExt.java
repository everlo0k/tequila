package cn.bigears.dubbo.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * BigOtherAdaptiveExt
 * @author shenyang
 * @date 2019/12/10
 */
@Adaptive
public class BigOtherAdaptiveExt implements BigAdaptiveExt {

    @Override
    public String echo(String msg, URL url) {
        return "other";
    }
}
