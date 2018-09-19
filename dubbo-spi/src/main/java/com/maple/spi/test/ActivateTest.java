package com.maple.spi.test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.maple.spi.Registry;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * 从上面的几个测试用例，可以得到下面的结论：
 * 1. 根据loader.getActivateExtension中的 group 和搜索到此类型的实例进行比较，如果group能匹配到，就是我们选择的，也就是在此条件下需要激活的。
 * <p>
 * 2. @Activate中的value是参数是第二层过滤参数（第一层是通过group），在group校验通过的前提下，如果URL中的参数（k）与值（v）中的参数名同@Activate中的value值一致或者包含，
 * 那么才会被选中。相当于加入了value后，条件更为苛刻点，需要URL中有此参数并且，参数必须有值。
 * <p>
 * 3.@Activate的order参数对于同一个类型的多个扩展来说，order值越小，优先级越高。
 *
 * @author maple 2018.09.16 下午4:40
 */
public class ActivateTest {

    /**
     * @Activate 注解中声明group
     */
    @Test
    public void test1() {
        ExtensionLoader<Registry> loader = ExtensionLoader.getExtensionLoader(Registry.class);
        URL url = URL.valueOf("test://localhost/test");
        //查询组为default_group的 Registry 的实现
        List<Registry> list = loader.getActivateExtension(url, new String[]{}, "default_group");

        System.out.println(list.size());

        System.out.println(list.get(0).getClass());


    }

    /**
     * @Activate注解中声明多个group
     */
    @Test
    public void test2() {
        ExtensionLoader<Registry> loader = ExtensionLoader.getExtensionLoader(Registry.class);
        URL url = URL.valueOf("test://localhost/test");
        //查询组为default_group的 Registry 的实现
        List<Registry> list = loader.getActivateExtension(url, new String[]{}, "etcd");

        System.out.println(list.size());

        System.out.println(list.get(0).getClass());


    }

    /**
     * 测试三：@Activate注解中声明了group与value
     */
    @Test
    public void test3() {
        URL url = URL.valueOf("test://localhost/test");
        //根据   key = value1, group =  value
        //@Activate(value = {"value1"}, group = {"value"})来激活扩展
        url = url.addParameter("dapeng", "dapeng1");

        ExtensionLoader<Registry> loader = ExtensionLoader.getExtensionLoader(Registry.class);

        //查询组为default_group的 Registry 的实现
        List<Registry> list = loader.getActivateExtension(url, new String[]{}, "dapeng");

        System.out.println(list.size());

        System.out.println(list.get(0).getClass());


    }

    /**
     * Activate 注解中声明了order,低的排序优先级搞
     */
    @Test
    public void test4() {
        URL url = URL.valueOf("test://localhost/test");

        ExtensionLoader<Registry> loader = ExtensionLoader.getExtensionLoader(Registry.class);

        //查询组为default_group的 Registry 的实现
        List<Registry> list = loader.getActivateExtension(url, new String[]{}, "etcd");

        System.out.println(list.size());

        System.out.println(list.get(0).getClass());
    }

    /**
     * test5
     */
    @Test
    public void test5() {
        URL url = URL.valueOf("test://localhost/test");

        ExtensionLoader<Registry> loader = ExtensionLoader.getExtensionLoader(Registry.class);
//        loader.getDefaultExtensionName()

        Registry zookeeper = loader.getExtension("etcd");
        Registry defaultExtension = loader.getDefaultExtension();


        String zookeeper1 = zookeeper.register(url, "zookeeper");

        System.out.println("结果:" + zookeeper1);

        Set<String> supportedExtensions = loader.getSupportedExtensions();
        //不会算 wrapper类
        supportedExtensions.forEach(System.out::println);

    }

    @Test
    public void test6() {
        URL url = URL.valueOf("test://localhost/test");

        ExtensionLoader<Registry> loader = ExtensionLoader.getExtensionLoader(Registry.class);

        Registry adaptiveExtension = loader.getAdaptiveExtension();

        String register = adaptiveExtension.register(URL.valueOf("maple"), "maple");

        System.out.println(register);


    }

    /**
     * 自动寻找适配器类
     */
    @Test
    public void test7() {
        URL url = URL.valueOf("test://localhost/test").addParameter("registry1", "etcd2");

        Registry registry = ExtensionLoader.getExtensionLoader(Registry.class).getAdaptiveExtension();

        String register = registry.register(url, "maple");

        System.out.println(register);

    }


}
