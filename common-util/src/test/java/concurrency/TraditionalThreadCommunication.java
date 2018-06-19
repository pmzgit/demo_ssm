package concurrency;
/**
 * 参考： https://github.com/brianway/java-learning/blob/master/blogs/javase/java%E5%9F%BA%E7%A1%80%E5%B7%A9%E5%9B%BA%E7%AC%94%E8%AE%B0(5)-%E5%A4%9A%E7%BA%BF%E7%A8%8B%E4%B9%8B%E4%BC%A0%E7%BB%9F%E5%A4%9A%E7%BA%BF%E7%A8%8B.md
 * 要用到共同数据(包括同步锁)或共同算法的若干个方法应该归在同一个类身上，这种设计体现了高聚类和程序的健壮性。
 同步互斥不是在线程上实现，而是在线程访问的资源上实现，线程调用资源。
 例子: 子线程循环5次，主线程循环10次，如此交替50次

 设计：

 使用一个Business类来包含子线程和主线程要运行的代码，从而，该类的对象成为加锁的对象。同步互斥在该类实现，由线程调用该类的方法，即调用了资源。
 *
 */
public class TraditionalThreadCommunication {
    public static void main(String[] args) {
        Business business = new Business();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=1;i<=50;i++){
                            business.sub(i);
                        }
                    }
                }
        ).start();

        for(int i=1;i<=50;i++){
            business.main(i);
        }

    }
}

class Business{
    private boolean bShouldSub = true;

    public synchronized void sub(int i){
        while(!bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=1;j<=5;j++){
            System.out.println("sub thread count "+j+","+i+"/50");
        }
        bShouldSub = false;
        this.notify();
    }
    public synchronized void main(int i){
        while(bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=1;j<=10;j++){
            System.out.println("main thread count "+j+","+i+"/50");
        }
        bShouldSub = true;
        this.notify();
    }
}