package cn.bigears.dubbo.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * OrderOneActivateExt
 * @author shenyang
 * @date 2019/10/24
 */
@Activate(order = 1, group = {"order"}, value = "orderOne")
public class OrderOneActivateExt implements BigActivateExt {
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
