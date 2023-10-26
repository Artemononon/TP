package org.example;
import java.util.*;
public class Thesaurus {
    private Map<String, Set<String>> synonyms;
    public Thesaurus() {
        synonyms = new HashMap<>();
    }
    public void add(String term, String synonym) {
        if (synonyms.containsKey(term)) {
            Set<String> existingSynonyms = synonyms.get(term);
            if (!existingSynonyms.contains(synonym)) {
                existingSynonyms.add(synonym);
                Set<String> sortedSynonyms = new TreeSet<>(existingSynonyms);
                synonyms.put(term, sortedSynonyms);
            } else {
                System.out.println("\nCиноним \"" + synonym + "\" уже существует.");
            }
        } else {
            Set<String> newSynonyms = new TreeSet<>();
            newSynonyms.add(synonym);
            synonyms.put(term, newSynonyms);
        }
    }
    public Set<String> get(String term) {
        return synonyms.get(term);
    }
    public void print() {
        List<String> sortedTerms = new ArrayList<>(synonyms.keySet());
        Collections.sort(sortedTerms);
        for (String term : sortedTerms) {
            Set<String> termSynonyms = synonyms.get(term);
            System.out.println(term + ": " + termSynonyms);
        }
    }
}