package com.epam.task3.leaf;

import com.epam.task3.composite.Component;
import com.epam.task3.exception.InvalidLeafOperation;

/**
 * Created by Никита on 14.12.2015.
 */
public class ListingLeaf implements Component {
    private String listing;

    public ListingLeaf() {
    }

    public ListingLeaf(String listing) {
        this.listing = listing;
    }

    @Override
    public String toString() {
        return listing;
    }

    @Override
    public void addElement(Component component) throws InvalidLeafOperation {
        throw new InvalidLeafOperation();
    }
}
