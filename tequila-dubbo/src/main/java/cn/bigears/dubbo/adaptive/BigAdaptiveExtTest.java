package cn.bigears.dubbo.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * BigAdaptiveExtTest
 * @author shenyang
 * @date 2019/10/23
 */
public class BigAdaptiveExtTest {

    public static void main(String[] args) {

        /**
         * 1. 如果实现类上面有@Adaptive,使用该类为默认实现,且最多只有一个实现类带有@Adaptive注解
         * 2. 如果实现类上面没有@Adaptive,则必须在接口方法上面要@Adaptive,dubbo会动态创建一个扩展类
         * 2.1 如果SPI注解没有默认值,且URL也没有传值,则调用getAdaptiveExtension报错找不到扩展类
         * 2.2 如果SPI注解有默认值,且URL也没有传值,则使用默认值对应的扩展类
         * 2.3 如果SPI注解有默认值,且URL也有传值,则先匹配URL中对应的扩展类,如果匹配不上,则使用默认值对应的扩展类
         * 2.4 如果@Adaptive注解没有值，则URL中的key为Extension接口类名的点分隔小写字串
         *     比如BigAdaptiveExt,则key为big.adaptive.ext
         * 2.5 如果@Adaptive注解有值,则URL中的key应写成@Adaptive注解注解的值
         */
        ExtensionLoader<BigAdaptiveExt> extExtensionLoader = ExtensionLoader.getExtensionLoader(BigAdaptiveExt.class);
        BigAdaptiveExt bigAdaptiveExt = extExtensionLoader.getAdaptiveExtension();
        // URL.valueOf(test://localhost/test?big.adaptive.ext=cloud)
        // URL.valueOf(test://localhost/test?t=cloud)
        URL url = URL.valueOf("test://localhost/test");
        System.out.println(bigAdaptiveExt.echo("",url));

    }

}
