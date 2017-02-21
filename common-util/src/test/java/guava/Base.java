package guava;

import com.google.common.base.Optional;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

import java.util.Objects;

/**
 * Created by pmz on 2017/1/23.
 */
public class Base {
    @Test
    public void testOption(){
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());
        // jdk objects
       // Objects.equals("a","a");
        System.out.println(com.google.common.base.Objects.equal(null,null));
        System.out.println("www".hashCode());
        System.out.println(HashCodeBuilder.reflectionHashCode(this));
        ToStringBuilder.getDefaultStyle();
    }
}
