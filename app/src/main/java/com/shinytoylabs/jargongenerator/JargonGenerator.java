package com.shinytoylabs.jargongenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by s.elgas on 2/26/2015.
 */
public class JargonGenerator {

    public final int MAX_WORD_POOL_SIZE = 10;

    private ArrayList<ArrayList<String>> _wordPool;
    private ArrayList<String> _wordCache;
    private ArrayList<String> _constructs;

    public JargonGenerator() {
        Reset();
    }

    public void Reset() {
        _wordPool = new ArrayList<ArrayList<String>>();
        _wordCache = new ArrayList<String>();
        _constructs = new ArrayList<String>();

        for (int i = 0; i < MAX_WORD_POOL_SIZE; i++) {
            _wordPool.add(new ArrayList<String>());
        }
    }

    public void AddWord(String word, int index) {
        if (index >= 0 && index < MAX_WORD_POOL_SIZE)
            _wordPool.get(index).add(word);
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
        _wordCache.clear();

        // pull out a random construct and build a sentence
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(_constructs.size());
        return buildSentence(randomIndex);
    }

    private String buildSentence(int constructIndex) {
        // split the construct into individual words
        String construct = _constructs.get(constructIndex);
        String [] words = construct.split(" ");
        String sentence = "";

        // scan each word for a pool index, and build a sentence
        for(int i = 0; i < words.length; i++) {
            if (i > 0)
                sentence += " ";
            String word = buildWord(words[i]);

            // make sure the first word is capitalized
            if (i == 0 && word.length() > 0)
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

            // parse the pool index and get a random word (index out of bounds = muffins)
            int poolIndex = Integer.parseInt(word.substring(leftBracket + 1, rightBracket));
            if (poolIndex < 0 || poolIndex >= MAX_WORD_POOL_SIZE)
                result += "muffins";
            else
                result += getRandomWord(poolIndex);

            // include any characters after the brackets
            if (rightBracket < word.length() - 1)
                result += word.substring(rightBracket + 1, word.length());
        }
        else
            result = word;

        return result;
    }

    private String getRandomWord(int poolIndex) {
        // make sure we have at least one word, otherwise muffins
        ArrayList<String> wordList = _wordPool.get(poolIndex);
        if (wordList.size() < 1)
            return "muffins";

        // pull a random word from the list of this type
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(wordList.size());
        String word = wordList.get(randomIndex);

        // if we've already used this word, find a different one
        int iterations = 0;
        boolean reused = false;
        while(_wordCache.contains(word)) {
            randomIndex++;
            if (randomIndex >= wordList.size())
                randomIndex = 0;
            word = wordList.get(randomIndex);

            // if we've used up every word, just re-use the first one
            iterations++;
            if (iterations > wordList.size()) {
                reused = true;
                break;
            }
        }

        // if it's not a re-used word, add it to the cache so we don't use it again
        if (!reused)
            _wordCache.add(word);

        return word;
    }
}
