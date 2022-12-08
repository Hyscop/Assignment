package com.assignment;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class App {

    static Database database;
    static String parser = "--------------------------------------";

    static void open() {
        System.out.println("Welcome to GROL App!");
    }

    static void close() {
        System.out.println("See you later for another shopping!");
    }

    static void checkRoutineList() {
        List list = database.getList();

        Calendar today = Calendar.getInstance();
        System.out.println("Checking database to find routine lists...");
        for (int i = 0; i < list.size(); i++) {
            ShoppingList item = (ShoppingList) list.get(i);
            Calendar itemDate = Calendar.getInstance();
            itemDate.setTime(item.getDate());

            if (item.getIsRoutine() && today.get(Calendar.YEAR) == itemDate.get(Calendar.YEAR)
                    && today.get(Calendar.MONTH) == itemDate.get(Calendar.MONTH)
                    && today.get(Calendar.DAY_OF_MONTH) == itemDate.get(Calendar.DAY_OF_MONTH)) {
                System.out.println("    Name: " + item.getName() + " is a routine list and it's time for shopping.");

            }
        }
    }

    static void login(String username, String password) {
        System.out.println("Trying to log in with username:" + username);
        User user = database.getUser(username);
        if (user == null || (!user.getUsername().equals(username) && !user.getPassword().equals(password))) {
            System.out.println("Unauthorized user");
            return;
        }

        System.out.println("Welcome " + user.getUsername());

    }

    public static void main(String[] args) {
        App.database = new Database();

        User user1 = new User("Mehmet__", "123456", "112233");
        User user2 = new User("Sinan26", "123456", "112233");
        database.createUser(user1);
        database.createUser(user2);

        // Use case 1:
        System.out.println(parser);
        System.out.println("[USE CASE] Scenario 1 \n");
        open();
        login("Mehmet__", "112233");
        ShoppingList shoppingList1 = new ShoppingList("gr0cery", new Date(), user1);
        database.createList(shoppingList1);

        Item item1 = new Item("Apple", 3);
        System.out.println("[OUTPUT] Added item "+ item1.getName() +" to the list " + shoppingList1.getName());
        Item item2 = new Item("Melon", 2);
        System.out.println("[OUTPUT] Added item "+ item2.getName() +" to the list " + shoppingList1.getName());
        shoppingList1.addItem(item1);
        shoppingList1.addItem(item2);
        shoppingList1.print();

        System.out.println("[OUTPUT] List Name: " + shoppingList1.getName() + " Is routine? " + shoppingList1.getIsRoutine() + " Is Done: " + shoppingList1.isDone());
        shoppingList1.setDate(new Date());
        shoppingList1.setIsRoutine(true);
        shoppingList1.setName("Grocery");
        shoppingList1.setDone(true);
        System.out.println("[OUTPUT] List is Updated: " + shoppingList1.getName() + " Is routine? " + shoppingList1.getIsRoutine() + " Is Done: " + shoppingList1.isDone());
        close();

        ShoppingList shoppingList2 = new ShoppingList("Health", new Date(), user2);
        database.createList(shoppingList2);
        Item item3 = new Item("Medicine", 2);
        Item item4 = new Item("Medicine2", 2);
        shoppingList2.addItem(item3);
        shoppingList2.addItem(item4);

        // Use case 2:
        System.out.println(parser);
        System.out.println("[USE CASE] Scenario 2 \n");
        open();
        login("Sinan26", "112233");
        shoppingList2.print();
        shoppingList2.changeItemQuantity(item3, 20);
        System.out.println("[OUTPUT] Changed item quantity of " + item3.getName());
        shoppingList2.changeItemQuantity(item4, 5);
        System.out.println("[OUTPUT] Changed item quantity of " + item4.getName());
        shoppingList2.print();
        close();

        // Alternate Path
        System.out.println(parser);
        System.out.println("[USE CASE] Scenario 2.1: Alternate \n");
        shoppingList2.print();
        shoppingList2.changeItemQuantity(item3, 0);
        System.out.println("[OUTPUT] Changed item quantity of " + item3.getName());
        shoppingList2.changeItemQuantity(item4, 0);
        System.out.println("[OUTPUT] Changed item quantity of " + item4.getName());
        shoppingList2.print();
        close();


        // Use case 3
        System.out.println(parser);
        System.out.println("[USE CASE] Scenario 3 \n");
        checkRoutineList();
        open();
        login("Mehmet__", "112233");
        shoppingList1.setDone(true);
        System.out.println("[OUTPUT] Changed isDone of " + shoppingList1.getName() + " to " + shoppingList1.isDone() );
        close();
        System.out.println(parser);



        database.print();
    }
}
