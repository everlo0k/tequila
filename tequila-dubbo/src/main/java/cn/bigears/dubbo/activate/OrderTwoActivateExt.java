package cn.bigears.dubbo.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * OrderTwoActivateExt
 * @author shenyang
 * @date 2019/10/24
 */
@Activate(order = 2, group = "order",value = "orderTwo")
public class OrderTwoActivateExt implements BigActivateExt {
    /**
     * 输出
     * @param msg msg
     * @return 输出内容
     */
    @Override
    public String echo(String msg) {
        return msg;
    }
}
