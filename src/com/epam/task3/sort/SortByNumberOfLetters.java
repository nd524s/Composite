package com.epam.task3.sort;

import com.epam.task3.exception.EmptyTextException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Никита on 18.12.2015.
 */
public class SortByNumberOfLetters {
    public static final String WORD_REGEX = "[A-Za-z']+\\s?";
    public static char letter = 'a';

    public ArrayList<String> sort(String text, char letter) throws EmptyTextException {
        if(text.isEmpty()){
            throw new EmptyTextException();
        }
        ArrayList<String> words = searchWordByLetter(parseToWord(text),letter);
        words = bubbleSort(words, letter);
        ArrayList<String> sortedWords = new ArrayList<>();

        for (ArrayList<String> group : sortWordGroups(words,letter)) {
            Collections.sort(group);
            sortedWords.addAll(group);
        }
       return sortedWords;
    }

    private ArrayList<ArrayList<String>> sortWordGroups(ArrayList<String> words, char letter){
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        int countOfLetters = countRepetitions(words.get(0), letter);
        int numberOfGroup = 0;
        groups.add(new ArrayList<>());

        for (String word : words) {
            if (countRepetitions(word, letter) > countOfLetters) {
                countOfLetters = countRepetitions(word,letter);
                groups.add(new ArrayList<>());
                numberOfGroup++;
            } else {
                groups.get(numberOfGroup).add(word);
            }
        }
        return groups;
    }

    private ArrayList<String> bubbleSort(ArrayList<String> words, char letter){
        for (int i = words.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(countRepetitions(words.get(j), letter) > countRepetitions(words.get(j + 1), letter)){
                    String tmp = words.get(j);
                    words.set(j, words.get(j+1));
                    words.set(j+1, tmp);
                }
            }
        }
        return words;
    }

    private int countRepetitions(String word, char letter) {
        int count = 0;

        for ( int i = 0; i < word.length(); i++) {
            if ( word.toLowerCase().charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    private ArrayList<String> parseToWord(String text) {
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> words = new ArrayList<>();

        while(matcher.find()) {
            words.add(matcher.group().toLowerCase());
        }
        return words;
    }

    private ArrayList<String> searchWordByLetter(ArrayList<String> words, char letter){
        Iterator<String> iterator = words.iterator();

        while (iterator.hasNext()){
            String word = iterator.next();

            if(!word.contains(String.valueOf(letter))){
                iterator.remove();
            }
        }
        return words;
    }
}
