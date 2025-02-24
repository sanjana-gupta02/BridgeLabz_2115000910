import java.util.List;
import java.util.ArrayList;
public class SuppressUncheckedWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        List list = new ArrayList();
        list.add(1);
        list.add("Hello");
        System.out.println(list);
    }
}
