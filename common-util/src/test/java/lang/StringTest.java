package lang;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.security.MessageDigest;
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

    // 测试从Base64编码转换为图片文件
//  String strImg = "";
    @Test
    public void testImage(){

//        GenerateImage(GetImageStr("C:\\Users\\Administrator\\Desktop\\pmz\\ocr\\sfz (2).jpg"), "D:\\aliyun-menu2.png");
        // 测试从图片文件转换为Base64编码
//      System.out.println(GetImageStr("d:\\aliyun-menu2.png"));
    }


    public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   /* @Test
    public static String MD5Base64(String s) {
        if (s == null)
            return null;
        String encodeStr = "";
        byte[] utfBytes = s.getBytes();
        MessageDigest mdTemp;
        try {
            mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(utfBytes);
            byte[] md5Bytes = mdTemp.digest();
            BASE64Encoder b64Encoder = new BASE64Encoder();
            encodeStr = b64Encoder.encode(md5Bytes);
        } catch (Exception e) {
            throw new Error("Failed to generate MD5 : " + e.getMessage());
        }
        return encodeStr;
    }*/
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
