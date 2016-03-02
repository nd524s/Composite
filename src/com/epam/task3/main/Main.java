package com.epam.task3.main;


import com.epam.task3.action.FileLoader;
import com.epam.task3.sort.SortByNumberOfLetters;
import com.epam.task3.sort.SortByNumberOfWords;
import com.epam.task3.action.TextModificator;
import com.epam.task3.composite.CompositeText;
import com.epam.task3.exception.EmptyTextException;
import com.epam.task3.parser.TextParser;
import com.epam.task3.report.Report;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        FileLoader fileLoader = new FileLoader();
        TextModificator textModificator = new TextModificator();
        TextParser textParser = new TextParser();
        CompositeText fullText = new CompositeText();
        String text = fileLoader.loadText("resources/first.txt");
        SortByNumberOfWords sortByNumberOfWords = new SortByNumberOfWords();
        SortByNumberOfLetters sortByNumberOfLetters = new SortByNumberOfLetters();
        Report report = new Report();
        report.printTextFile(text);
        report.printSingleStringText(text,textModificator);
        report.printSortedByNumberOfLetters(text,sortByNumberOfLetters,textModificator, SortByNumberOfLetters.letter);
        report.printSortedByNumberOfWords(text,sortByNumberOfWords);
        report.printCompositeObject(fullText, textParser, text);

    }

}
