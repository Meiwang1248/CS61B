import java.util.Iterator;
import java.util.NoSuchElementException;

/** OHQueue is a linked list consisted of certain amount of OHRequest,
 * we need to build a iterator to iterate through the OHDeque's OHRequest.*/

public class OHRequest {
    public String description;
    public String name;
    public OHRequest next;

    public OHRequest(String description, String name, OHRequest next) {
        this.description = description;
        this.name = name;
        this.next = next;
    }
}



