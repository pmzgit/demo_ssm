package io;

import org.junit.Ignore;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by pmz on 2017/2/21 15:20.
 */
@Ignore
public class IOTest {

    @Test
    public void testFile(){
        File file = new File("./");
        /*try {
            file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(File.pathSeparator);
        file.list();
        file.listFiles();
        print(file);
    }

    @Test
    public void create(){
        File file = new File("d:/tmp/aa.exe");
        //            file.createNewFile();
        file.delete();
        print(file);
    }

    public static void print(File f){
        if (f!=null){
            if (f.isDirectory()){
                File[] files = f.listFiles();
                if (files != null){
                    for (int i=0; i<files.length; i++){
                        print(files[i]);
                    }
                }
            }else {
                System.out.println(f.getName());
                System.out.println(f.getPath());
                System.out.println(f.getAbsolutePath());
                try {
                    System.out.println(f.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void ws(){
        String fileName="D:"+File.separator+"hello.txt";
        File f=new File(fileName);
        OutputStream out = null;
        try {
            out = new FileOutputStream(f,true);
            String str="你好2a";
            byte[] b=str.getBytes();
            System.out.println(Arrays.toString(b));
            int a = b[2];
            System.out.println(a);
//            out.write(b);
            for (int i = 0 ; i<b.length; i++){
                out.write(b[i]);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String read(String filename) throws Exception {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new  File(
                    filename).getAbsoluteFile()),Charset.forName("gbk")));
            String s;
            try {
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    @Test
    public void testBufferedReader() throws Exception {
        System.out.println(read("d:/hello.txt"));
    }
    @Test
    public void testMemoryInput() throws Exception{
        StringReader sr = new StringReader(read("d:/hello.txt"));
        int c;
        while ((c = sr.read()) != -1){
            System.out.println(c);
            System.out.println((char)c);
        }

    }

    public static void copyByte(File sourceFile, File targetFile){
//        https://blog.csdn.net/fireofjava/article/details/7220754
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));) {
//            byte[] buffer = new byte[bis.available()];
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            bos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void copyChar(File source, File target){
        try(BufferedReader bf = new BufferedReader(new FileReader(source));
            BufferedWriter bw = new BufferedWriter(new FileWriter(target));){
            String str = null;
            while ((str = bf.readLine()) != null) {
               bw.write(str);
               bw.newLine();
            }
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void testEncode(File source, File target) throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(source), Charset.forName("utf-8"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(target), Charset.forName("utf-8"));
    }
}
