import org.junit.Test;
import sun.misc.BASE64Encoder;

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


}
