package qrcode;

import org.iherus.codegen.qrcode.QrcodeGenerator;
import org.iherus.codegen.qrcode.SimpleQrcodeGenerator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

/**
 * Created by pmz on 2018/3/19 11:33.
 */
public class Gen {
    private static String content = "https://www.baidu.com/s?ie=UTF-8&wd=junit%20Before";

    private QrcodeGenerator generator = new SimpleQrcodeGenerator();

    private String localLogoPath;
    @Before
    public void init(){
        URL url = this.getClass().getClassLoader().getResource("qrcode/AodaCat-1.png");
        String path = url.getPath();
        String file = url.getFile();
        this.localLogoPath = file;
        System.out.println(path);
        System.out.println(file);

    }
    @Test
    public void testDefault(){
        try {
            generator.generate(content).toFile("d:/qrcode.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
