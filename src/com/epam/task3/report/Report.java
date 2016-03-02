package com.epam.task3.report;

import com.epam.task3.composite.CompositeText;
import com.epam.task3.parser.TextParser;
import com.epam.task3.sort.SortByNumberOfLetters;
import com.epam.task3.sort.SortByNumberOfWords;
import com.epam.task3.action.TextModificator;
import com.epam.task3.exception.EmptyTextException;
import org.apache.log4j.Logger;

/**
 * Created by Никита on 20.12.2015.
 */
public class Report {
    static Logger log = Logger.getLogger(Report.class);

    public void printTextFile(String text){
        System.out.println(text);
    }

    public void printSingleStringText(String text, TextModificator textModificator){
        System.out.println("---Single string text---");
        try {
            System.out.println(textModificator.toSingleString(text));
        } catch (EmptyTextException e) {
            log.error("Empty text");
        }
    }

    public void printSortedByNumberOfLetters(String text, SortByNumberOfLetters sortByNumberOfLetters, TextModificator textModificator, char letter){
        System.out.println("---Ascending sort by number of letters in the words---");
        try {
            for (String word : sortByNumberOfLetters.sort(textModificator.toSingleString(text), letter) ) {
                System.out.print(word + " ");
            }
        } catch (EmptyTextException e) {
            log.error("Empty text");
        }
        System.out.println();
    }

    public void printSortedByNumberOfWords(String text, SortByNumberOfWords sortByNumberOfWords){
        System.out.println("---Ascending sort by number of words in the sentences--");
        try {
            for (String sentence : sortByNumberOfWords.sort(text)) {
                System.out.println(sentence);
            }
        } catch (EmptyTextException e) {
            log.error("Empty text");
        }
    }

    public void printCompositeObject(CompositeText fullText,TextParser textParser, String text){
        System.out.println(" ---Result of compiling our composite object--- ");
        try {
            fullText = textParser.parseText(fullText, text);
        } catch (EmptyTextException e) {
            log.error("Empty text");
        }
        System.out.println(fullText.toString());
    }
}
