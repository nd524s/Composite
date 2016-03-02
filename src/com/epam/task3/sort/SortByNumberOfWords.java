package com.epam.task3.sort;

import com.epam.task3.exception.EmptyTextException;
import com.epam.task3.parser.TextParser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Никита on 18.12.2015.
 */
public class SortByNumberOfWords {

    public ArrayList<String> sort(String text) throws EmptyTextException {
        if(text.isEmpty()){
            throw new EmptyTextException();
        }
        ArrayList<String> sentences = parseToSentence(parseToParagraph(text));

        for (int i = sentences.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(countWords(sentences.get(j)) > countWords(sentences.get(j + 1))){
                    String tmp = sentences.get(j);
                    sentences.set(j, sentences.get(j+1));
                    sentences.set(j+1, tmp);
                }
            }
        }
      return sentences;
    }

    private String parseToParagraph(String text) {
        Pattern pattern = Pattern.compile(TextParser.PARAGRAPH_REGEX);
        Matcher matcher = pattern.matcher(text);
        StringBuilder builder = new StringBuilder();

        while(matcher.find()) {
            builder.append(matcher.group());
        }
        return builder.toString();
    }

    private ArrayList<String> parseToSentence(String paragraphs) {
        Pattern pattern = Pattern.compile(TextParser.SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(paragraphs);
        ArrayList<String> sentences = new ArrayList<>();
        String s;

        while(matcher.find()) {
            s= matcher.group();
            sentences.add(s);
        }
        return sentences;
    }

    private int countWords(String sentence){
        Pattern pattern = Pattern.compile(SortByNumberOfLetters.WORD_REGEX);
        Matcher matcher = pattern.matcher(sentence);
        int count = 0;

        while(matcher.find()) {
            count++;
        }
        return count;
    }

}
