package com.assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingList {
    private int id;
    private String name;
    private boolean isDone;
    private boolean isRoutine;
    private Date date;
    List itemList;

    ShoppingList(String name, Date date){
        this.id = IdGenerator.generate();
        this.name = name;
        this.date = date;
        itemList = new ArrayList<Item>();
        this.isDone = false;
        this.isRoutine = false;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsRoutine() {
        return isRoutine;
    }

    public void setIsRoutine(boolean isRoutine) {
        this.isRoutine = isRoutine;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

}
