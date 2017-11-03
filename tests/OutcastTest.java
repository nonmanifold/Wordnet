import edu.princeton.cs.algs4.In;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class OutcastTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private String createOutcast(String outcastsFileName) {
        WordNet wordnet = new WordNet("synsets.txt", "hypernyms.txt");

        Outcast outcast = new Outcast(wordnet);

        In in = new In(outcastsFileName);
        String[] nouns = in.readAllStrings();
        return outcast.outcast(nouns);
    }

    @Test
    public void Validate_outcast_02() {
        String outcasts = createOutcast("outcast2.txt");
        assertEquals("Turing", outcasts);
    }

    @Test
    public void Validate_outcast_05() {
        String outcasts = createOutcast("outcast5.txt");
        assertEquals("table", outcasts);
    }

    @Test
    public void Validate_outcast_08() {
        String outcasts = createOutcast("outcast8.txt");
        assertEquals("bed", outcasts);
    }

    @Test
    public void Validate_outcast_11() {
        String outcasts = createOutcast("outcast11.txt");
        assertEquals("potato", outcasts);
    }
}
