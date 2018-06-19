package concurrency;

/**
 * Created by pmz on 2017/9/24 20:06.
 */
public class Volatile1 {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Volatile1 test = new Volatile1();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                    System.out.println(test.inc);
                };
            }.start();
        }



    }


}
