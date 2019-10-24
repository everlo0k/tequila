package cn.bigears.dubbo.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * BigDefaultActivateExt
 * @author shenyang
 * @date 2019/10/24
 */
@Activate(group = {"default_group"})
public class BigDefaultActivateExt implements BigActivateExt {
    /**
     * 输出
     * @param msg msg
     * @return 输出内容
     */
    @Override
    public String echo(String msg) {
        return "default";
    }
}
