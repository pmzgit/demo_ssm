package annotation;

/**
 * Created by pmz on 2017/5/19 12:35.
 */
public class Info {
    @InfoFieldAnnotation(InfoFieldAnnotation.Status.SECOND)
    private String status;
    @InfoMethodAnnotation
    public void notSetVal(){
        System.out.println("notsetval");
    }
    @InfoMethodAnnotation(author = "ppp",version = 2)
    public void setVal(){
        System.out.println("setval");
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
