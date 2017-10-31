import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class SAPTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void Validate_digraph1() {
        In in = new In("digraph1.txt");
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        assertEquals(4, sap.length(3, 11));
        assertEquals(1, sap.ancestor(3, 11));

        assertEquals(3, sap.length(9, 12));
        assertEquals(5, sap.ancestor(9, 12));


        assertEquals(4, sap.length(7, 2));
        assertEquals(0, sap.ancestor(7, 2));

        assertEquals(-1, sap.length(1, 6));
        assertEquals(-1, sap.ancestor(1, 6));
    }

    @Test
    public void Validate_digraph2() {
        In in = new In("digraph2.txt");
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        assertEquals(2, sap.length(1, 5));
        assertEquals(0, sap.ancestor(1, 5));
    }
}
