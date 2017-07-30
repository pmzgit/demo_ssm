package annotation;

import java.lang.annotation.*;

/**
 * Created by pmz on 2017/5/19 12:32.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoMethodAnnotation {
   String author() default "lilei";
   int version() default 1;
}
