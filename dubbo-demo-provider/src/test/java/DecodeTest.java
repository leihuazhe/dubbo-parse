import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-12-10 12:17 AM
 */
public class DecodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "dubbo%3A%2F%2F172.16.18.150%3A20880%2Fcom.maple.dubbo.api.DemoService%3Fanyhost%3Dtrue%26application%3Ddemo-provider%26dubbo%3D2.6.1%26generic%3Dfalse%26interface%3Dcom.maple.dubbo.api.DemoService%26methods%3DsayHello%26pid%3D41512%26side%3Dprovider%26timestamp%3D1544372058734";
        String url2 = "dubbo%3A%2F%2F172.16.18.150%3A20882%2Fcom.maple.dubbo.api.DemoService%3Fanyhost%3Dtrue%26application%3Ddemo-provider%26dubbo%3D2.6.1%26generic%3Dfalse%26interface%3Dcom.maple.dubbo.api.DemoService%26methods%3DsayHello%26pid%3D41646%26side%3Dprovider%26timestamp%3D1544372487532";
        String decode = URLDecoder.decode(url2, "utf-8");

        System.out.println(decode);

    }
}
