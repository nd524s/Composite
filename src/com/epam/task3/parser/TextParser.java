package com.epam.task3.parser;

import com.epam.task3.action.TextModificator;
import com.epam.task3.composite.Component;
import com.epam.task3.composite.CompositeText;
import com.epam.task3.exception.EmptyTextException;
import com.epam.task3.leaf.CharacterLeaf;
import com.epam.task3.leaf.ListingLeaf;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Никита on 14.12.2015.
 */
public class TextParser {
    public static final String PARAGRAPH_REGEX = "\\t.*?\\v";
    public static final String SENTENCE_REGEX = ".*?(?:[.!:]\\s?|\\?\\s)";
    public static final String WORD_SIGN_REGEX = ".*?\\s";
    public static final String SYMBOL_REGEX = ".{1}";
    public static final String LISTING_REGEX = "//:.*?~";

    public CompositeText parseText(CompositeText fullText,String text) throws EmptyTextException {
        CompositeText paragraphList = new CompositeText();
        Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
        Matcher matcher = pattern.matcher(text);
        String paragraph;

        if(text.isEmpty()){
            throw new EmptyTextException();
        }
        while (matcher.find()) {
            paragraph = matcher.group();
            paragraphList = parseToSentence(paragraphList, paragraph);
        }

        fullText.addElement(compileCompositeObject(paragraphList, text));
        return fullText;
    }

    private CompositeText compileCompositeObject(CompositeText compositeText, String text) throws EmptyTextException {
        String str;
        char ch;
        int index;
        int j = 0;
        int k = 0;
        ArrayList<Component> paragraphs = compositeText.getComponent();
        ArrayList<Component> result = new ArrayList<>();
        ArrayList<Component> listings = parseToListing(text);

        for (int i = 0; i < paragraphs.size(); i++) {
            str = paragraphs.get(k).toString();
            index = str.length()-2;
            ch = str.charAt(index);
            result.add(paragraphs.get(k));
            k++;
            if(ch ==':') {
                result.add(listings.get(j));
                j++;
            }
        }
        compositeText.removeAll();
        compositeText.addAll(result);
        return compositeText;
    }

    private CompositeText parseToSentence(CompositeText paragraphList, String paragraph){
        CompositeText sentenceList = new CompositeText();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(paragraph);
        String sentence;

        while(matcher.find()){
            sentence = matcher.group();
            sentenceList = parseToWordAndSign(sentenceList, sentence);

        }
        paragraphList.addElement(sentenceList);
        return paragraphList;
    }

    private CompositeText parseToWordAndSign(CompositeText sentenceList, String sentence){
        CompositeText wordAndSignList = new CompositeText();
        Pattern pattern = Pattern.compile(WORD_SIGN_REGEX);
        Matcher matcher = pattern.matcher(sentence);
        String wordAndSign;

        while(matcher.find()){
            wordAndSign = matcher.group();
            wordAndSignList = parseToCharacter(wordAndSignList, wordAndSign);

        }
        sentenceList.addElement(wordAndSignList);
        return sentenceList;
    }

    private CompositeText parseToCharacter(CompositeText wordAndSignList,String wordAndSign){
        CharacterLeaf element;
        Pattern pattern = Pattern.compile(SYMBOL_REGEX);
        Matcher matcher = pattern.matcher(wordAndSign);
        char[] symbol;

        while (matcher.find()){
            symbol =matcher.group().toCharArray();
            element = new CharacterLeaf(symbol[0]);
            wordAndSignList.addElement(element);
        }
        return wordAndSignList;
    }

    private ArrayList<Component> parseToListing(String text) throws EmptyTextException {
        Pattern pattern = Pattern.compile(LISTING_REGEX);
        Matcher matcher = pattern.matcher(new TextModificator().toSingleString(text));
        ArrayList<Component> listings = new ArrayList<>();
        String listing;

        if(text.isEmpty()){
            throw new EmptyTextException();
        }
        while (matcher.find()) {
            listing = matcher.group();
            listings.add(new ListingLeaf(listing));
        }
        return listings;
    }
}
