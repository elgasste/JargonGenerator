package com.shinytoylabs.jargongenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by s.elgas on 2/26/2015.
 */
public class JargonGenerator {

    public enum WordType {
        ABBREVIATION(0), ADJECTIVE(1), NOUN(2), VERB(3), INGVERB(4);

        private final int value;
        private WordType(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    private ArrayList<ArrayList<String>> _wordPool;
    private ArrayList<ArrayList<String>> _cachePool;
    private ArrayList<String> _constructs;

    public JargonGenerator() {
        _wordPool = new ArrayList<ArrayList<String>>();
        _cachePool = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < WordType.values().length; i++) {
            _wordPool.add(new ArrayList<String>());
            _cachePool.add(new ArrayList<String>());
        }

        _constructs = new ArrayList<String>();
    }

    public void AddWord(String word, WordType wordType) {
        _wordPool.get(wordType.value).add(word);
    }

    public void AddConstruct(String construct) {
        _constructs.add(construct);
    }

    public String GenerateJargon() {
        // make sure we have at least one construct
        if (_constructs.size() < 1) {
            return "";
        }

        // always clear the cache first
        clearCache();

        // pull out a random construct and build a sentence
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(_constructs.size());
        return buildSentence(randomIndex);
    }

    private void clearCache() {
        for (int i = 0; i < WordType.values().length; i++) {
            _cachePool.get(i).clear();
        }
    }

    private String buildSentence(int constructIndex) {
        // split the construct into individual words
        String construct = _constructs.get(constructIndex);
        String [] words = construct.split(" ");
        String sentence = "";

        // scan each word for a type, and build a sentence
        for(int i = 0; i < words.length; i++) {
            if (i > 0)
                sentence += " ";
            String word = buildWord(words[i]);

            // make sure the first word is capitalized
            if (i == 0)
                word = word.substring(0, 1).toUpperCase() + word.substring(1);

            sentence += word;
        }

        return sentence;
    }

    private String buildWord(String word) {
        int leftBracket = word.indexOf("{");
        int rightBracket = word.indexOf("}");
        String result = "";

        // check the word for brackets with at least one character inside
        if (leftBracket > -1 && rightBracket > (leftBracket + 1)) {
            // include any characters before the brackets
            if (leftBracket > 0)
                result += word.substring(0, leftBracket);

            // parse the type and get a random word of that type
            String type = word.substring(leftBracket + 1, rightBracket);
            result += getRandomWord(getWordTypeFromString(type));

            // include any characters after the brackets
            if (rightBracket < word.length() - 1)
                result += word.substring(rightBracket + 1, word.length());
        }
        else
            result = word;

        return result;
    }

    private String getRandomWord(WordType type) {
        // make sure we have at least one word, otherwise muffins
        ArrayList<String> wordList = _wordPool.get(type.value);
        if (wordList.size() < 1)
            return "muffins";

        // pull a random word from the list of this type
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(wordList.size());
        String word = wordList.get(randomIndex);

        // if we've already used this word, find a different one
        while(_cachePool.get(type.value).contains(word)) {
            randomIndex++;
            if (randomIndex >= wordList.size())
                randomIndex = 0;
            word = wordList.get(randomIndex);
        }

        // add this word to the cache so we don't use it again
        _cachePool.get(type.value).add(word);

        return word;
    }

    private WordType getWordTypeFromString(String type) {
        switch (type) {
            case "abbreviation":
                return WordType.ABBREVIATION;
            case "adjective":
                return WordType.ADJECTIVE;
            case "noun":
                return WordType.NOUN;
            case "verb":
                return WordType.VERB;
            case "ingverb":
                return WordType.INGVERB;
        }
        return WordType.ADJECTIVE;
    }
}
