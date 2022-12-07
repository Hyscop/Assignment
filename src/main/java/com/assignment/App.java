package com.assignment;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class App {

    static Database database;

    static void open() {
        System.out.println("Welcome to GROL App!");
    }

    static void close() {
        System.out.println("See you later for another shopping!");
    }

    static void checkRoutineList() {
        List list = database.getList();

        Calendar today = Calendar.getInstance();

        for (int i = 0; i < list.size(); i++) {
            ShoppingList item = (ShoppingList) list.get(i);
            Calendar itemDate = Calendar.getInstance();
            itemDate.setTime(item.getDate());

            if (item.getIsRoutine() && today.get(Calendar.YEAR) == itemDate.get(Calendar.YEAR)
                    && today.get(Calendar.MONTH) == itemDate.get(Calendar.MONTH)
                    && today.get(Calendar.DAY_OF_MONTH) == itemDate.get(Calendar.DAY_OF_MONTH)) {
                System.out.println("Name: " + item.getName() + " is a routine list and it's time for shopping.");

            }
        }
    }

    void login(String username, String password) {
        User user = database.getUser(username);
        if (user != null || (!user.getUsername().equals(username) && !user.getPassword().equals(password))) {
            System.out.println("Unauthorized user");
            return;
        }

        System.out.println("Welcome " + user.getUsername());

    }

    public static void main(String[] args) {
        App.database = new Database();

        open();
        System.out.println("-----------------------------------------------------------------------------");
        User user1 = new User("Mehmet__", "123456", "112233");
        User user2 = new User("Sinan26", "123456", "112233");

        ShoppingList shoppingList1 = new ShoppingList("manav", new Date(), user1);
        ShoppingList shoppingList2 = new ShoppingList("Kasap", new Date(), user2);

        shoppingList2.setIsRoutine(true);

        database.createList(shoppingList1);
        database.createList(shoppingList2);

        database.createUser(user1);
        database.createUser(user2);

        database.print();

        System.out.println("User1 id:" + user1.getId());
        System.out.println("User2 id:" + user2.getId());

        System.out.println("Shoppinglist2 id:" + shoppingList1.getId());
        System.out.println("Shoppinglist2 id:" + shoppingList2.getId());

        shoppingList2.isDone();
        shoppingList2.setDone(true);
        shoppingList2.isDone();

        shoppingList1.setDate(new Date());

        shoppingList1.getDate();

    }
}
