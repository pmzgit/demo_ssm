package designpattern.factory;

/**
 * Created by pmz on 2017/6/9 19:14.
 * @see <a href="http://www.cnblogs.com/xing901022/p/4034813.html" target="_top">抽象工厂模式</a>
 */
public interface ZCFactory {
    Staple makeStaple();
    Drink makeDrink();
}
