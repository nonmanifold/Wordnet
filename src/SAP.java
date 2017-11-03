import edu.princeton.cs.algs4.*;

import java.util.Arrays;
import java.util.Collections;

public class SAP {

    private final Digraph g;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        g = new Digraph(G);
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        return length(Collections.singleton(v), Collections.singleton(w));
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        return ancestor(Collections.singleton(v), Collections.singleton(w));
    }

    private void validateVertex(Integer v) {
        if (v == null || v < 0 || v > g.V() - 1) {
            throw new IllegalArgumentException();
        }
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException();
        }
        int length = Integer.MAX_VALUE;

        BreadthFirstDirectedPaths bfv = new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths bfw = new BreadthFirstDirectedPaths(g, w);
        for (int i = 0; i < g.V(); i++) {
            if (bfv.hasPathTo(i) && bfw.hasPathTo(i)) {
                // i is common ancestor
                int totalLength = bfv.distTo(i) + bfv.distTo(i);
                if (totalLength < length) {
                    length = totalLength;
                }
            }
        }
        if (length == Integer.MAX_VALUE) {
            length = -1;
        }
        return length;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException();
        }
        int length = Integer.MAX_VALUE;
        int ancestor = -1;
        BreadthFirstDirectedPaths bfv = new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths bfw = new BreadthFirstDirectedPaths(g, w);
        for (int i = 0; i < g.V(); i++) {
            if (bfv.hasPathTo(i) && bfw.hasPathTo(i)) {
                // i is common ancestor
                int totalLength = bfv.distTo(i) + bfv.distTo(i);
                if (totalLength < length) {
                    length = totalLength;
                    ancestor = i;
                }
            }
        }

        return ancestor;
    }

    // do unit testing of this class
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}