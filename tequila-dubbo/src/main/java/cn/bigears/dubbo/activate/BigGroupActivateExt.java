package cn.bigears.dubbo.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * BigGroupActivateExt
 * @author shenyang
 * @date 2019/10/24
 */
@Activate(group = {"group1", "group2"})
public class BigGroupActivateExt implements BigActivateExt {
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
