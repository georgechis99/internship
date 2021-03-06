package com.arobs.intenrship.lab6.ex4;

import java.util.*;

public class Dictionary {
    private HashMap<Word,Definition> pairs;

    public Dictionary() {
        pairs = new HashMap<>();
    }

    public void addWord(Word word,Definition definition){
        pairs.put(word,definition);
    }

    public void addWord(String word,String definition){
        Word word1 = new Word(word);
        Definition definition1 = new Definition(definition);
        addWord(word1,definition1);
    }

    public Definition getDefinition(Word word){
        return pairs.get(word);
    }

    public Set<Word> getAllWords(){
        return  pairs.keySet();
    }

    public List<Definition> getAllDefinitions(){
        Collection<Definition> pairsc =  pairs.values();
        return (List<Definition>) pairsc;
    }
}
