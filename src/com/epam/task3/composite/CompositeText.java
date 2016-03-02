package com.epam.task3.composite;

import java.util.ArrayList;

/**
 * Created by Никита on 14.12.2015.
 */
public class CompositeText implements Component {
    private ArrayList<Component> textParts = new ArrayList<>();

    public CompositeText() {
    }

    public CompositeText(ArrayList<Component> textParts) {
        this.textParts = textParts;
    }

    public ArrayList<Component> getComponent() {
        ArrayList<Component> list = new ArrayList<>();
        list.addAll(textParts);
        return list;
    }

    public void removeAll(){
        textParts.removeAll(textParts);
    }

    public void addAll(ArrayList<Component> list){
        textParts.addAll(list);
    }
    @Override
    public String toString() {
        String result = "";
        for (Component component : textParts) {
            result+=component.toString();
        }
        return result;
    }

    public void setTextParts(ArrayList<Component> textParts) {
        this.textParts = textParts;
    }

    @Override
    public void addElement(Component component) {
        textParts.add(component);
    }

}
