import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.File;

/**
 * Created by Administrator on 2016/11/8.
 */

public class StringTest {

    @Test
    public void testBase64(){
        BASE64Encoder encoder = new BASE64Encoder();
        String encryptStr = encoder.encode("women".getBytes());
        System.out.println(encryptStr);
    }

    @Test
    public void testContentEquals(){
//        System.out.println("wwbced".contentEquals("wwbced"));
        System.out.println("wwwefghs".contains("wefgh"));
    }
}
