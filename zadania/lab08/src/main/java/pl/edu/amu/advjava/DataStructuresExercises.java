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
        words.stream().forEach(word -> indexSingleWord(word, new HashSet(Arrays.asList(fileName) )));
    }

    Set<String> getMatchingFiles(String word) {
        return Optional.ofNullable(word)
                .map(w -> wordsIndex.get(w))
                .orElse(new HashSet<String>());
    }

    void indexAll(Map<String, Set<String>> otherIndex) {
        otherIndex.forEach(this::indexSingleWord);
    }

    private void indexSingleWord(String word, Set<String> filenames) {
        wordsIndex.merge(word, filenames, (v1, v2) -> {
            v1.addAll(v2);
            return v1;
        });
    }

    void fileDeleted(String fileName) {
        wordsIndex.forEach((word, filenames) -> {
            filenames.remove(fileName);
        });
        wordsIndex.values().removeIf(Set::isEmpty);
    }
}
