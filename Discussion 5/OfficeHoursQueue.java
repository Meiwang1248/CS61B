import java.util.Iterator;

public class OfficeHoursQueue implements Iterable<OHRequest> {
    OHRequest queue;

    public OfficeHoursQueue(OHRequest queue) {
        this.queue = queue;
    }


    @Override
    public Iterator<OHRequest> iterator() {
        return new OHIterator(queue);
    }
}
