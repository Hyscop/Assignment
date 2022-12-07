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
        // User oluşturma

        User user1 = new User("Mehmet__", "123456", "112233");
        User user2 = new User("Sinan26", "123456", "112233");

        // ShoppingList oluştuma ve userla mergelama

        ShoppingList shoppingList1 = new ShoppingList("manav", new Date(), user1);
        ShoppingList shoppingList2 = new ShoppingList("Kasap", new Date(), user2);

        // shoppingListlerin rutinlerini kontrol etme ve değiştirme
        System.out.println("Liste rutin mi?: " + shoppingList2.getIsRoutine());

        shoppingList2.setIsRoutine(true);
        System.out.println("Liste rutin mi?: " + shoppingList2.getIsRoutine());

        checkRoutineList();

        // dbye liste ekleme

        database.createList(shoppingList1);
        database.createList(shoppingList2);

        // dbye user ekleme

        database.createUser(user1);
        database.createUser(user2);

        database.print();

        System.out.println(database.getList());

        // listelerin alışverişleri tamamlandı mı?
        System.out.println("Lİste için alışveriş tamamlandı mı?: " + shoppingList2.isDone());

        shoppingList2.setDone(true);

        System.out.println("Lİste için alışveriş tamamlandı mı?: " + shoppingList2.isDone());

        System.out.println(shoppingList1.getDate());
        shoppingList1.setDate(new Date());
        System.out.println(shoppingList1.getDate());

        database.deleteList(shoppingList1.getId());
        database.print();

        // login
        login("Sinan26", "112233");
        login("Mehmet", "123456789");

        System.out.println(shoppingList2.getId() + " idli " + "listenin ismi: " + shoppingList2.getName());

        shoppingList2.setName("başka manav");

        System.out.println(shoppingList2.getId() + " idli " + "listenin ismi: " + shoppingList2.getName());

        Item item1 = new Item("Elma", 3);
        Item item2 = new Item("ayva", 2);

        System.out.println("current item count in: list1: " + shoppingList1.addItem(item1).size());
        System.out.println("Current Item count in: List1: " + shoppingList1.addItem(item2).size());

    }
}
