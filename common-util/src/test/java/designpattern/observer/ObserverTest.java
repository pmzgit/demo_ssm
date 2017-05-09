package designpattern.observer;

import org.junit.Test;

/**
 * Created by pmz on 2017/2/27 18:03.
 */
public class ObserverTest {

    @Test
    public void testObserve(){
        MySubject mySubject = new MySubject();
        User1 user1 = new User1();
        User2 user2 = new User2();
        mySubject.add(user1);
        mySubject.add(user2);
        // subject update
        mySubject.operation();
        /*update myself
user1 has received the update!
user2 has received the update!
        * */

    }
}
