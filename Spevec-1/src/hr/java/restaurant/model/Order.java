package hr.java.restaurant.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Order extends Entity{
    private Restaurant restaurant;
    private Meal[] meals;
    private Deliverer deliverer;
    private LocalDateTime deliveryDateAndTime;

    public Order(Long id, Restaurant restaurant, Meal[] meals, Deliverer deliverer, LocalDateTime deliveryDateAndTime) {
        super(id);
        this.restaurant = restaurant;
        this.meals = meals;
        this.deliverer = deliverer;
        this.deliveryDateAndTime = deliveryDateAndTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Meal[] getMeals() {
        return meals;
    }

    public void setMeals(Meal[] meals) {
        this.meals = meals;
    }

    public Deliverer getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    public LocalDateTime getDeliveryDateAndTime() {
        return deliveryDateAndTime;
    }

    public void setDeliveryDateAndTime(LocalDateTime deliveryDateAndTime) {
        this.deliveryDateAndTime = deliveryDateAndTime;
    }


    public static Order inputOrder(Scanner sc, Restaurant[] restaurants, Meal[] meals, Deliverer[] deliverers, int[] delCounter) {
        System.out.println("Enter restaurant (index): ");
        for (int j = 0; j < restaurants.length; j++) {
            System.out.println((j+1) + ". restaurant: " + restaurants[j].getName());
        }
        int index = sc.nextInt();
        sc.nextLine();
        while (index > restaurants.length || index <= 0) {
            System.out.println("Invalid index");
            index = sc.nextInt();
            sc.nextLine();
        }
        Restaurant helpRestaurant = restaurants[index - 1];

        System.out.println("Enter number of meals");
        int numberOfMeals = sc.nextInt();
        sc.nextLine();

        System.out.println("Choose meals you want to add to order (index): ");
        for (int j = 0; j < meals.length; j++) {
            System.out.println((j + 1) + ". meal: " + meals[j].getName());
        }

        Meal[] helpMeals = new Meal[numberOfMeals];
        for (int j = 0; j < numberOfMeals; j++) {
            System.out.println("Pick meal number " + (j + 1) + ": ");
            int number = sc.nextInt();
            sc.nextLine();

            while (number > meals.length || number <= 0) {
                System.out.println("Invalid index");
                number = sc.nextInt();
                sc.nextLine();
            }
            helpMeals[j] = meals[number - 1];

        }

            System.out.println("Enter deliverer (index): ");
            for (int j = 0; j < deliverers.length; j++) {
                System.out.println((j+1) + ". deliverer: " + deliverers[j].getFirstName() + " " + deliverers[j].getLastName());
            }
            int idx = sc.nextInt();
            sc.nextLine();
            while (idx > deliverers.length || idx <= 0) {
                System.out.println("Invalid index");
                idx = sc.nextInt();
                sc.nextLine();
            }

            delCounter[idx-1]++;

            Deliverer helpDeliverers = deliverers[idx - 1];

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

            System.out.println("Enter date and time of order (dd-MM-yyyy HH:mm): ");
            String date = sc.nextLine();

            LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

            return new Order(Long.valueOf(1),helpRestaurant, helpMeals, helpDeliverers, dateTime);
        }

    public static void mostExpensiveOrder(Order[] orders) {
        BigDecimal maxPrice = BigDecimal.ZERO;
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal sum2 = BigDecimal.ZERO;
        int index = 0;

        System.out.println("\n\nMost expensive orders are in restaraunt(s):");

        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].getMeals().length; j++) {
                sum = sum.add(orders[i].getMeals()[j].getPrice());
            }
            if (sum.compareTo(maxPrice) > 0) {
                maxPrice = sum;
                index = i;
            }
            sum = BigDecimal.ZERO;
        }

        for (int i = index; i < orders.length; i++) {
            for (int j = 0; j < orders[i].getMeals().length; j++) {
                sum2 = sum2.add(orders[i].getMeals()[j].getPrice());
            }
            if (sum2.compareTo(maxPrice) == 0) {
                Restaurant.printRestaurant(orders[i].getRestaurant(), orders[i].getRestaurant().getMeals(), orders[i].getRestaurant().getChefs(), orders[i].getRestaurant().getWaiters(), orders[i].getRestaurant().getDeliverers());
            }
            sum2 = BigDecimal.ZERO;
        }
    }
}
