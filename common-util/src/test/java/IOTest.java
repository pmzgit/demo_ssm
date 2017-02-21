import org.junit.Test;

import java.io.File;


public class IOTest {

    @Test
    public void testRemote(){
        String imgPath = "http://wx.qlogo.cn/mmopen/wdwjadXgY4DQk1gBmicpFzBogI4wEdMXaiapdPQ9qbf9mo3GhwOaunrRERZ3B3NLcLM2rjUiaDOyzEcUFyYTaPFGqiaiap6iaxvhcH/0";
        File file = new File(imgPath);
        if (!file.exists()) {
            System.err.println(""+imgPath+"   该文件不存在！");
            return;
        }else {
            System.out.println(file.canRead());
        }
    }
    @Test
    public void testMkdirs(){
        String file = "d:/test/aa.txt";
        String dir = "d:/test/testa/";
        File File = new File(file);
        File Dir = new File(dir);
        System.out.println("file: "+File.isDirectory());
        System.out.println("dir: "+Dir.isDirectory());
//        System.out.println(File.mkdirs());
//        System.out.println(Dir.mkdirs());
    }
}
