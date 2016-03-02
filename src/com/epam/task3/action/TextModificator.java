package com.epam.task3.action;

import com.epam.task3.exception.EmptyTextException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Никита on 15.12.2015.
 */
public class TextModificator {

    public String toSingleString(String text) throws EmptyTextException {
        Pattern pattern = Pattern.compile(".+\\v+");
        Matcher matcher = pattern.matcher(text);
        String str = "";

        if(text.isEmpty()){
            throw new EmptyTextException();
        }

        while (matcher.find()) {
            str+= matcher.group().replaceAll("\n|\r\n", "");;
        }
        return str;
    }

}
