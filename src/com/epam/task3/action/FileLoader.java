package com.epam.task3.action;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Никита on 15.12.2015.
 */
public class FileLoader {
    static Logger log = Logger.getLogger(FileLoader.class);

    public String loadText(String path){
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str); // String with all text
            // System.out.println(text);
        } catch (FileNotFoundException e) {
            log.error("File not found");
        } catch (IOException e) {
            log.error("File loading failed");
        }
        return text;
    }
}
