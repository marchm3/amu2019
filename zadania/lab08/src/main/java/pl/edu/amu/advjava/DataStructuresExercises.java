package pl.edu.amu.advjava;

import java.util.*;
import java.util.stream.Stream;

/*
    ZADANIE: zmodyfikuj kod, stosując programowanie funkcyjne tam, gdzie to możliwe
     */
final class DataStructuresExercises {

    Map<String, Set<String>> wordsIndex = new HashMap<>();

    void indexWords(List<String> words, String fileName) {
        if(words == null || fileName == null) {
            throw new IllegalArgumentException();
        }
        Stream.concat(
                wordsIndex.entrySet().stream(),
                words.stream()
        )

        for(String word : words) {
            if(!wordsIndex.containsKey(word)){
                wordsIndex.put(word, new HashSet<>());
            }
            wordsIndex.get(word).add(fileName);
        }
    }

    Set<String> getMatchingFiles(String word) {
        return Optional.ofNullable(word)
                .map(w -> wordsIndex.get(w))
                .orElse(new HashSet<String>());
    }

    void indexAll(Map<String, Set<String>> otherIndex) {

        for(Map.Entry<String, Set<String>> entry : otherIndex.entrySet()) {
            String word = entry.getKey();
            if(!wordsIndex.containsKey(word)){
                wordsIndex.put(word, new HashSet<>());
            }
            wordsIndex.get(word).addAll(entry.getValue());
        }
    }

    void fileDeleted(String fileName) {

        Set<Map.Entry<String, Set<String>>> mapEntries = wordsIndex.entrySet();
        Iterator<Map.Entry<String, Set<String>>> entriesIterator = mapEntries.iterator();
        while(entriesIterator.hasNext()) {
            Map.Entry<String, Set<String>> entry = entriesIterator.next();

            entry.getValue().remove(fileName);
            if(entry.getValue().isEmpty()){
                entriesIterator.remove();
            }
        }

    }

}
