package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */
/**
 *   BoundedQueue bq = new ArrayRingBuffer(4);
 *         bq.enqueue(33.1) // 33.1 null null  null
 *         x.enqueue(44.8) // 33.1 44.8 null  null
 *         x.enqueue(62.3) // 33.1 44.8 62.3  null
 *         x.enqueue(-3.4) // 33.1 44.8 62.3 -3.4
 *         x.dequeue()     // 44.8 62.3 -3.4  null (returns 33.1)*/
public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(3);
        assertTrue(arb.isEmpty());
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        assertTrue(arb.isFull());
        assertEquals((Integer) 1, arb.peek());
        assertEquals((Integer) 1, arb.dequeue());
        assertFalse(arb.isEmpty());
        assertFalse(arb.isFull());
        assertEquals((Integer) 2, arb.peek());
        arb.enqueue(4);
        assertTrue(arb.isFull());






    }
}
