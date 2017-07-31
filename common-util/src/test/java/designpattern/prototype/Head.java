package designpattern.prototype;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Created by pmz on 2017/5/26 13:34.
 */
public class Head implements Serializable{

    public String name;

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("name",name)
                .toString();
    }
}
