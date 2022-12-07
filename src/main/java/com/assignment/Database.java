package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Database {
    List shoppingLists;
    List userList;

    Database() {
        shoppingLists = new ArrayList<ShoppingList>();
        userList = new ArrayList<User>();
    }

    List getList() { 
        return this.shoppingLists;
     }

     List getUsers() {
        return this.userList;
     }

    List createList(Object list) {
        if(!this.typeCheck(ShoppingList.class, list)) return null;
        shoppingLists.add(list);
        return this.shoppingLists;
    }

    ShoppingList updateList(int id, Object list) {
        if(!this.typeCheck(ShoppingList.class, list)) return null;

        ShoppingList current = null;
        for(int i = 0; i<this.shoppingLists.size(); i++) {
            current = (ShoppingList) this.shoppingLists.get(i);
            if(current.getId() == id) {
                current = (ShoppingList) list;
                break;
            }
        }
        return current;

    }

    List deleteList(int id) {
        for(int i = 0; i<this.shoppingLists.size(); i++) {
            ShoppingList current = (ShoppingList) this.shoppingLists.get(i);
            if(current.getId() == id) {
                this.shoppingLists.remove(i);
                break;
            }
        }
        return this.shoppingLists;
    }

    List createUser(User user) {
        if(!this.typeCheck(User.class, user)) return null;
        this.userList.add(user);
        return this.userList;
    }

    User getUser(String username) {
        User user = null;
        for(int i = 0; i<this.shoppingLists.size(); i++) {
            User current = (User) this.userList.get(i);
            if(current.getUsername() == username) {
                user = (User) this.userList.get(i);
                break;
            }
        }
        return user;
    }

    User getUser(int id) {
        User user = null;
        for(int i = 0; i<this.shoppingLists.size(); i++) {
            User current = (User) this.userList.get(i);
            if(current.getId() == id) {
                user = (User) this.userList.get(i);
                break;
            }
        }
        return user;
    }


    void print() {
        System.out.println("Printing database...");
        System.out.println("Shopping Lists:");
        System.out.print("[ ");
        for(int i = 0; i<this.shoppingLists.size(); i++) {
            ShoppingList current = (ShoppingList) this.shoppingLists.get(i);
            System.out.print(" { id: "+ current.getId() + ", name: " + current.getName() + " }\n");
        }
        System.out.print(" ]");
        System.out.println("User List:");
        System.out.print("[ ");
        for(int i = 0; i<this.userList.size(); i++) {
            User current = (User) this.userList.get(i);
            System.out.print(" { id: "+ current.getId() + ", name: " + current.getUsername() + " }\n");
        }
        System.out.print(" ]");
    }

    private boolean typeCheck (Object type, Object item) {
        return item.getClass().getName() == type.getClass().getName();

    }
}
