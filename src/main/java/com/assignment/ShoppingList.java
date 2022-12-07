package com.assignment;

import java.util.Date;
import java.util.List;

public class ShoppingList {

    List Item;

    int id;
    private boolean isDone;

    private boolean isRoutine;

    private Date date;

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
