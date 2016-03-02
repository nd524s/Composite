package com.epam.task3.composite;

import com.epam.task3.exception.InvalidLeafOperation;


/**
 * Created by ������ on 14.12.2015.
 */
public interface Component {
    void addElement(Component component) throws InvalidLeafOperation;
    String toString();
}
