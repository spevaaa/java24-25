package hr.java.restaurant.model;

import java.util.Scanner;

public class Restaurant extends Entity {

    private String name;
    private Address address;
    private Meal[] meals;
    private Chef[] chefs;
    private Waiter[] waiters;
    private Deliverer[] deliverers;

    public Restaurant(Long id, String name, Address address, Meal[] meals, Chef[] chefs, Waiter[] waiters, Deliverer[] deliverers) {
        super(id);
        this.name = name;
        this.address = address;
        this.meals = meals;
        this.chefs = chefs;
        this.waiters = waiters;
        this.deliverers = deliverers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Meal[] getMeals() {
        return meals;
    }

    public void setMeals(Meal[] meals) {
        this.meals = meals;
    }

    public Chef[] getChefs() {
        return chefs;
    }

    public void setChefs(Chef[] chefs) {
        this.chefs = chefs;
    }

    public Waiter[] getWaiters() {
        return waiters;
    }

    public void setWaiters(Waiter[] waiters) {
        this.waiters = waiters;
    }

    public Deliverer[] getDeliverers() {
        return deliverers;
    }

    public void setDeliverers(Deliverer[] deliverers) {
        this.deliverers = deliverers;
    }

    public static Restaurant inputRestaurant(Scanner sc, Meal[] meals, Chef[] chefs, Waiter[] waiters, Deliverer[] deliverers) {
        System.out.println("Enter restaurant name: ");
        String name = sc.nextLine();


        System.out.println("Enter restaurant address: ");
        Address adress1 = new Address(Long.valueOf(1), "0", "0", "0", "0");
        adress1.inputAddress(sc);


        System.out.println("Enter number of meals");
        int numberOfMeals = sc.nextInt();
        sc.nextLine();

        System.out.println("Choose meals you want to add to restaurant (index): ");
        for (int j = 0; j < meals.length; j++) {
            System.out.println((j + 1) + ". meal: " + meals[j].getName());
        }

        Meal[] helpMeals = new Meal[numberOfMeals];
        for (int i = 0; i < numberOfMeals; i++) {
            System.out.println("Pick meal number " + (i + 1) + ": ");
            int number = sc.nextInt();
            sc.nextLine();
            while (number <= 0 || number > meals.length){
                System.out.println("Invalid index");
                number = sc.nextInt();
                sc.nextLine();
            }
            helpMeals[i] = meals[number - 1];
        }


        System.out.println("Enter number of chefs: ");
        int numberOfChefs = sc.nextInt();
        sc.nextLine();

        System.out.println("Choose chefs you want to add to restaurant (index): ");
        for (int j = 0; j < chefs.length; j++) {
            System.out.println((j+1) + ". chef: " + chefs[j].getFirstName() + " " + chefs[j].getLastName());
        }

        Chef[] helpChefs = new Chef[numberOfChefs];
        for (int i = 0; i < numberOfChefs; i++) {
            System.out.println("Pick chef number " + (i + 1) + ": ");
            int number = sc.nextInt();
            sc.nextLine();
            while (number <= 0 || number > chefs.length){
                System.out.println("Invalid index");
                number = sc.nextInt();
                sc.nextLine();
            }
            helpChefs[i] = chefs[number - 1];
        }


        System.out.println("Enter number of waiters: ");
        int numberOfWaiters = sc.nextInt();
        sc.nextLine();

        System.out.println("Choose waiters you want to add to restaurant (index): ");
        for (int j = 0; j < waiters.length; j++) {
            System.out.println((j+1) + ". waiter: " + waiters[j].getFirstName() + " " + waiters[j].getLastName());
        }

        Waiter[] helpWaiters = new Waiter[numberOfWaiters];
        for (int i = 0; i < numberOfWaiters; i++) {
            System.out.println("Pick waiter number " + (i + 1) + ": ");
            int number = sc.nextInt();
            sc.nextLine();
            while (number <= 0 || number > waiters.length){
                System.out.println("Invalid index");
                number = sc.nextInt();
                sc.nextLine();
            }
            helpWaiters[i] = waiters[number - 1];
        }


        System.out.println("Enter number of deliverers: ");
        int numberOfDeliverers = sc.nextInt();
        sc.nextLine();

        System.out.println("Choose deliverers you want to add to restaurant (index): ");
        for (int j = 0; j < deliverers.length; j++) {
            System.out.println((j + 1) + ". deliverer: " + deliverers[j].getFirstName() + " " + deliverers[j].getLastName());
        }

        Deliverer[] helpDeliverers = new Deliverer[numberOfDeliverers];
        for (int i = 0; i < numberOfDeliverers; i++) {
            System.out.println("Pick deliverer number " + (i + 1) + ": ");

            int number = sc.nextInt();
            sc.nextLine();

            while (number > deliverers.length || number <= 0) {
                System.out.println("Invalid index");
                number = sc.nextInt();
                sc.nextLine();
            }

            helpDeliverers[i] = deliverers[number - 1];
        }

        return new Restaurant(Long.valueOf(1),name, adress1, helpMeals, helpChefs, helpWaiters, helpDeliverers);
    }


    public static void printRestaurant (Restaurant restaurant, Meal[] meals, Chef[] chefs, Waiter[] waiters, Deliverer[] deliverers) {

        System.out.println("Name: " + restaurant.getName());
        System.out.println("Address: " + restaurant.getAddress().getStreet() + " " + restaurant.getAddress().getHouseNumber());
        for (Meal meal : restaurant.getMeals()) {
            System.out.println("Meals: " + meal.getName());
        }
        for (Chef chef : restaurant.getChefs()) {
            System.out.println("Chefs: " + chef.getFirstName() + " " + chef.getLastName());
        }
        for (Waiter waiter : restaurant.getWaiters()) {
            System.out.println("Waiters: " + waiter.getFirstName() + " " + waiter.getLastName());
        }
        for (Deliverer deliverer : restaurant.getDeliverers()) {
            System.out.println("Deliverers: " + deliverer.getFirstName() + " " + deliverer.getLastName());
        }
    }
}