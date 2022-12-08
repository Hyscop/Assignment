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

        open();
        System.out.println("-----------------------------------------------------------------------------");
        
        // Create user
        User user1 = new User("Mehmet__", "123456", "112233");
        User user2 = new User("Sinan26", "123456", "112233");

        // Add User into database
        database.createUser(user1);
        database.createUser(user2);

        // Create ShoppingList and connect with User
        ShoppingList shoppingList1 = new ShoppingList("manav", new Date(), user1);
        ShoppingList shoppingList2 = new ShoppingList("Kasap", new Date(), user2);

        // login
        login("Sinan26", "112233");
        login("Mehmet", "123456789");

        // Add Lists into database
        database.createList(shoppingList1);
        database.createList(shoppingList2);

        // Check and update if the ShoppingList is Routine
        System.out.println("Liste rutin mi?: " + shoppingList2.getIsRoutine());
        shoppingList2.setIsRoutine(true);
        System.out.println("Liste rutin mi?: " + shoppingList2.getIsRoutine());


        // Check the database for all ShoppingList to fetch RoutineLists
        checkRoutineList();

        //Print the database, User and ShoppingList
        database.print();

        // System.out.println(database.getList());

        // Change List Properties
        System.out.println("List Name: " + shoppingList2.getName() + " Is done:" + shoppingList2.isDone());
        shoppingList2.setDone(true);
        shoppingList2.setName("Another Name List");
        System.out.println("List Name: " + shoppingList2.getName() + " Is done:" + shoppingList2.isDone());

        System.out.println(shoppingList1.getDate());
        shoppingList1.setDate(new Date());
        System.out.println(shoppingList1.getDate());


        // Delete List
        database.deleteList(shoppingList1.getId());
        database.print();

        // Adding Items to the List
        Item item1 = new Item("Elma", 3);
        Item item2 = new Item("ayva", 2);

        shoppingList1.addItem(item1);
        shoppingList1.addItem(item2);
        shoppingList1.print();
        
        //Changing quantity of an Item
        System.out.println("[FUNCTION] Change quantity to 55 " + item2.getName());
        shoppingList1.changeItemQuantity(item1, 55);
        shoppingList1.print();

        //Deleting Item
        System.out.println("[FUNCTION] Delete item " + item2.getName());
        shoppingList1.deleteItem(item1);
        shoppingList1.print();

        //Changing quantity to 0 of an Item
        System.out.println("[FUNCTION] Change quantity to 0 " + item2.getName());
        shoppingList1.changeItemQuantity(item2, 0);
        shoppingList1.print();



    }
}
