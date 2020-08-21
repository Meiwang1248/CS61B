import org.junit.Test;

import static junit.framework.Assert.*;

public class TestUnionFind {
    UnionFind aov = new UnionFind(8);

    @Test
    public void testBasics() {
        aov.union(1,7);
        aov.union(2,3);
        aov.union(3,4);
        aov.union(2,5);

        assertTrue(aov.connected(3,5));
        assertTrue(aov.connected(1,7));
        assertFalse(aov.connected(0,6));

        assertEquals(4,aov.sizeOf(5));
        assertEquals(-4, aov.ArrayOfVertices[3]);
        assertEquals(7, aov.parent(1));
        assertEquals(-1, aov.ArrayOfVertices[0]);
        assertEquals(3, aov.find(5));
    }
}
