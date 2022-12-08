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
    User user;

    ShoppingList(String name, Date date, User user) {
        this.id = IdGenerator.generate();
        this.name = name;
        this.date = date;
        itemList = new ArrayList<Item>();
        this.isDone = false;
        this.isRoutine = false;
        this.user = user;
        user.shoppingList.add(this);
    }


    List addItem(Item item) {
        this.itemList.add(item);
        return this.itemList;
    }

    List deleteItem(Item item){
        this.itemList.remove(item);
        item = null;
        return this.itemList;
    }

    void changeItemQuantity(Item item, int quantity) {
        if(quantity > 0) {
            item.setQuantity(quantity);
        } else {
            this.deleteItem(item);
        }
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


    void print(){
        System.out.println("LIST NAME: " + this.getName() );
        if(itemList.size() == 0 ) System.out.println("  There is no items in this list.");
        for(int i = 0; i<itemList.size(); i++) {
            Item item = (Item) this.itemList.get(i);
            System.out.println("    Item Name: "+ item.getName() + " Quantity: " + item.getQuantity());
        }
    }
}
