package annotation;

import java.lang.annotation.*;

/**
 * Created by pmz on 2017/5/19 12:27.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoFieldAnnotation {
    enum Status {FIRST,SECOND}

    Status value() default Status.FIRST;
}
