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
    public void Loading_SimpleSynsetAndHypernyms() {
        WordNet wn = new WordNet("synsets3.txt", "hypernyms3InvalidCycle.txt");
        assertTrue("Contain 'a'", wn.isNoun("a"));
        assertFalse("Does not contain 'x'", wn.isNoun("x"));
        Iterable<String> nouns = wn.nouns();
        List<String> nounsArr = StreamSupport.stream(nouns.spliterator(), false).collect(Collectors.toList());
       // List<String> nounsArr = FluentIterable.from(nouns).toList();
        assertArrayEquals(new String[]{"a", "b", "c"}, nounsArr.toArray());
    }
}
