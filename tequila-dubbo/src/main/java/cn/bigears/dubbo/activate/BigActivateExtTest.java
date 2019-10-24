package cn.bigears.dubbo.activate;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.List;

/**
 * BigActivateExtTest
 * @author shenyang
 * @date 2019/10/24
 */
public class BigActivateExtTest {

    public static void main(String[] args) {

        /**
         * getActivateExtension使用方法的分析
         * 1.如果传values参数,则和META-INF/dubbo/internal配置文件中的key匹配加载,和group没关系
         * 2.如果传group参数,url不带参数,则同时按照按照group匹配,匹配实现类中@Activate注解中group相同且没有配置value的实现
         * 3.如果传group参数,url带参数且值不空,则同时匹配实现类中@Activate注解中group相同,且url的参数名称(或者如aa.orderOne,这样以.key的方式结尾)=@Activate注解的value的实现
         *   (url参数等于的值,可以随便写,只要不为空就能匹配)
         */
        ExtensionLoader<BigActivateExt> extensionLoader = ExtensionLoader.getExtensionLoader(BigActivateExt.class);
        URL url = URL.valueOf("test://localhost/test");
        url = url.addParameter("aa.orderOne", "1");
        List<BigActivateExt> list = extensionLoader.getActivateExtension(url, new String[]{"group","default"}, "order");
        System.out.println(list.size());
        for (BigActivateExt bigActivateExt : list) {
            System.out.println(bigActivateExt.getClass().getName());
        }

    }
}
