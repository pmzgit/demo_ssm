package lang;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.security.MessageDigest;
import java.util.Arrays;
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



    @Test
    public void testSplit(){

        // 正则表达式 \\ 代表一个\ 转义字符

        String[] a = "boo|and|foo".split("\\|");// . | 都是转义字符
        System.out.println(Arrays.toString(a));

        String[] b = "acount=? and uu =? or n=?".split("and|or");

        System.out.println(Arrays.toString(b));

        System.out.println("aaa\\bbb\\ccc");
        /**
         * 所以，要怎么弄，它不是要拿着这个反斜杠去转义一个东西吗，然后现在这个东西还丢了，
         * 我就再给你一个反斜杠，你拿反斜杠去转义反斜杠，结果就是一个反斜杠了嘛。
         * 现在的参数是"\\"，也就是一个反斜杠，我们需要再给它一个反斜杠，于是就是"\\\\"，
         * 现在就是两个反斜杠了。这就变成什么东西了呢，"\\\\"是一个字符串，这个字符串里面有两个字符，两个都是反斜杠，
         * 在正则表达式里面，他拿到一个反斜杠之后，要去转义后面的字符，也就变成了用一个反斜杠去转义一个反斜杠，结果就是一个反斜杠了对吧。
         * 所以下面代码：String s = "ABC";
         String s3 = s.replaceAll("B", "\\\\");
         System.out.println(s3);
         输出结果是A\C。


         * @author pmz
         * @date 2017/6/10
         *
         */
        // 设计到正则表达式 加 \ 那就 需要两步， \\ 代表一个转义字符  \\ 代表一个反斜杠
        String[] c = "aaa\\bbb\\ccc".split("\\\\");
        System.out.println(Arrays.toString(c));

        //
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        // 预期大于 3，结果是 3
        System.out.println(ary.length);
    }
}
