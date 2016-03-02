package com.epam.task3.leaf;

import com.epam.task3.composite.Component;
import com.epam.task3.exception.InvalidLeafOperation;

/**
 * Created by Никита on 14.12.2015.
 */
public class CharacterLeaf implements Component {
    private char element;

    public CharacterLeaf() {
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }

    public CharacterLeaf(char element) {
        this.element = element;
    }

    public char getElement() {
        return element;
    }

    public void setElement(char element) {
        this.element = element;
    }

    @Override
    public void addElement(Component component) throws InvalidLeafOperation {
        throw new InvalidLeafOperation();
    }

}
