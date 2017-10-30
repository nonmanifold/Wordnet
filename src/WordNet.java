import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.*;

public class WordNet {

    private final Digraph hypernymsGraph;
    private HashMap<String, Integer> nouns = new HashMap<>();

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        In synsetsStream = new In(synsets);
        int v=0;
        while (synsetsStream.hasNextLine()) {
            String[] segments = synsetsStream.readLine().split(",");
            int synsetId = Integer.parseInt(segments[0]);
            v++;
            List<String> synonyms = Arrays.asList(segments[1].split(" "));
            for (String synonym : synonyms) {
                nouns.put(synonym, synsetId);
            }
        }

        hypernymsGraph = new Digraph(v);
        In hypernymsStream = new In(hypernyms);
        SAP sap = new SAP(hypernymsGraph);
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return nouns.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return nouns.containsKey(word);
    }

    // distance between nounA and nounB
    public int distance(String nounA, String nounB) {

        int nounAId=nouns.get(nounA);
        int nounBId=nouns.get(nounB);

        return 0;
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path
    //  An ancestral path between two vertices v and w in a digraph
    //  is a directed path from v to a common ancestor x,
    //  together with a directed path from w to the same ancestor x.
    //  A shortest ancestral path is an ancestral path of minimum total length.
    public String sap(String nounA, String nounB) {
        return null;
    }

    // do unit testing of this class
    public static void main(String[] args) {
    }
}