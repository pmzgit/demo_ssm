package designpattern.prototype;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by pmz on 2017/5/26 13:04.
 */
public class Body implements Serializable{

    private String bodyName;

    private Head head;

    public Body(){
        head = new Head();
    }

    public String getBodyName() {
        return bodyName;
    }

    public void setBodyName(String bodyName) {
        this.bodyName = bodyName;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(String a) {
        this.head.name = a;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("bodyName", bodyName)
                .add("head", head)
                .toString();
    }
}
