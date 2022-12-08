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

    List createList(ShoppingList list) {
        shoppingLists.add(list);
        return this.shoppingLists;
    }

    boolean deleteList(ShoppingList item) {
        return this.shoppingLists.remove(item);
    }

    List deleteList(int id) {
        for (int i = 0; i < this.shoppingLists.size(); i++) {
            ShoppingList current = (ShoppingList) this.shoppingLists.get(i);
            if (current.getId() == id) {
                this.shoppingLists.remove(i);
                break;
            }
        }
        return this.shoppingLists;
    }

    List createUser(User user) {
        this.userList.add(user);
        return this.userList;
    }

    User getUser(String username) {
        User user = null;
        for (int i = 0; i < this.userList.size(); i++) {
            User current = (User) this.userList.get(i);
            if (current.getUsername() == username) {
                user = (User) this.userList.get(i);
                break;
            }
        }
        return user;
    }

    User getUser(int id) {
        User user = null;
        for (int i = 0; i < this.shoppingLists.size(); i++) {
            User current = (User) this.userList.get(i);
            if (current.getId() == id) {
                user = (User) this.userList.get(i);
                break;
            }
        }
        return user;
    }

    void print() {
        System.out.println("Printing database...");
        System.out.println("Shopping Lists:");
        System.out.println("[");
        for (int i = 0; i < this.shoppingLists.size(); i++) {
            ShoppingList current = (ShoppingList) this.shoppingLists.get(i);
            System.out.println(" { id: " + current.getId() + ", name: " + current.getName() + ", belongs: " +  current.user.getUsername()+" }\n");
        }
        System.out.println("]\n");
        System.out.println("User List:");
        System.out.println("[");
        for (int i = 0; i < this.userList.size(); i++) {
            User current = (User) this.userList.get(i);
            System.out.println(" { id: " + current.getId() + ", username: " + current.getUsername() + " }\n");
        }
        System.out.print("]\n");
    }

}
