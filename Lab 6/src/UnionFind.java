import java.util.Arrays;

public class UnionFind {

    // TODO - Add instance variables?
    int[] ArrayOfVertices;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        // TODO
        ArrayOfVertices = new int[n];
        for (int i = 0; i < ArrayOfVertices.length; i++) {
            ArrayOfVertices[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        // TODO
        if (vertex >= ArrayOfVertices.length || vertex < 0) {
            throw new IllegalArgumentException("v1 is not a valid index");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        // TODO
        validate(v1);
        return -parent(find(v1));
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        validate(v1);
        return ArrayOfVertices[v1];

    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a
       vertex with itself or vertices that are already connected should not
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        // TODO
        validate(v1);
        validate(v2);
        if (! connected(v1, v2)){
            if (sizeOf(v1) > sizeOf(v2)){
                ArrayOfVertices[find(v1)] -= sizeOf(v2);
                ArrayOfVertices[find(v2)] = find(v1);
            } else {
                ArrayOfVertices[find(v2)] -= sizeOf(v1);
                ArrayOfVertices[find(v1)] = find(v2);
             }
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // TODO
        validate(vertex);
        while (parent(vertex) >= 0) {
            vertex = parent(vertex);
        }
        return vertex;
    }

}
