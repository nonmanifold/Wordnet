import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class WordNetTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void Loading_SynsetAndHypernyms() {
        WordNet wn = new WordNet("synsets.txt", "hypernyms.txt");
        assertTrue("Contain 'worm'", wn.isNoun("worm"));
        assertFalse("Does not contain 'zzzzzzz'", wn.isNoun("zzzzzzz"));
        Iterable<String> nouns = wn.nouns();
        List<String> nounsArr = StreamSupport.stream(nouns.spliterator(), false).collect(Collectors.toList());
        assertEquals("contain 119188 nouns", 119188, nounsArr.size());
        assertEquals(23, wn.distance("white_marlin", "mileage"));
        assertEquals(23, wn.distance("mileage", "white_marlin"));

        assertEquals(33, wn.distance("Black_Plague", "black_marlin"));

        assertEquals(27, wn.distance("American_water_spaniel", "histology"));

        assertEquals(29, wn.distance("Brown_Swiss", "barrel_roll"));
        assertEquals(3, wn.distance("municipality", "region"));

        assertEquals(5, wn.distance("edible_fruit", "physical_entity"));
    }

    @Test
    public void ThrowIAEonTwoRoots() {
        thrown.expect(IllegalArgumentException.class);
        new WordNet("synsets3.txt", "hypernyms3InvalidTwoRoots.txt");
    }

    @Test
    public void ThrowIAEonInvalidCycle() {
        thrown.expect(IllegalArgumentException.class);
        new WordNet("synsets3.txt", "hypernyms3InvalidCycle.txt");
    }


}
