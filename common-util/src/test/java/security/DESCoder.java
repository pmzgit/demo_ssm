package security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/**
 * Created by pmz on 2017/5/25 17:54.
 */
public class DESCoder {
    private static final String DES = "DES";
    private static final byte[] ENCRYPT_KEY = {-81, 0, 105, 7, -32, 26, -49, 88};
    public static String encrypt(String data) throws Exception{
        byte[] bytes = encrypt(data.getBytes(),ENCRYPT_KEY);
        String result = new BASE64Encoder().encode(bytes);
        return result;
    }

    public static String decrypt(String data) throws IOException,
            Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf,ENCRYPT_KEY);
        return new String(bt);
    }
    private static byte[] encrypt(byte[] data, byte[] key)
            throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
//        Byte[] aa = Arrays.asList(key).subList(0,8).toArray();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    public static byte[] format(String str){
        byte[] bt=str.getBytes();
        if(bt.length<8){
            byte[] btnew=new byte[8];
            for(int i=0;i<bt.length;i++){
                btnew[i]=bt[i];
            }
            for(int i=bt.length;i<8;i++){
                btnew[i]=0;
            }
            return btnew;
        }
        return bt;
    }

    public static void main(String[] args) throws Exception{
        String data = "123women123women123women123women123women";
        System.out.println(encrypt(data));
        System.out.println(decrypt("eWOYHX3zl4R5Y5gdffOXhHljmB1985eEeWOYHX3zl4R5Y5gdffOXhOYHHj4AarNm"));
    }
}
