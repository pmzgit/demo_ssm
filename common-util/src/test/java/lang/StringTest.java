package lang;

import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Administrator on 2016/11/8.
 */

public class StringTest {
   /**
    * 
    *@author:pmzgit
    *@date:2017/1/11
    */ 
    @Test
    public void testBase64(){
        BASE64Encoder encoder = new BASE64Encoder();
        String encryptStr = encoder.encode("women".getBytes());
        System.out.println(encryptStr);
    }
    /**
     * 
     *@author:pmzgit
     *@date:2017/1/11
     */
    @Test
    public void testContentEquals(){
//        System.out.println("wwbced".contentEquals("wwbced"));
        System.out.println("wwwefghs".contains("wefgh"));
        String a = "ww";
        a.equals("w");
    }
    @Test
    public void getUUID(){
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
    @Test
    public void testEquals(){
        System.out.println(Objects.equals("1","2"));
    }
}
