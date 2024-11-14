package hr.java.production.main;

import hr.java.restaurant.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Category[] categories = new Category[3];
        Ingredient[] ingredients = new Ingredient[5];
        Meal[] meals = new Meal[3];
        Chef[] chefs = new Chef[3];
        Waiter[] waiters = new Waiter[3];
        Deliverer[] deliverers = new Deliverer[3];
        Restaurant[] restaurants = new Restaurant[3];
        Address[] addresses = new Address[3];
        Order[] orders = new Order[3];

        int[] deliveryCounter = {0, 0, 0};


        for(int i = 0; i < categories.length; i++) {
            System.out.println("Enter details for category " + (i + 1));
            categories[i].inputCategories(sc);
        }

        for(int i=0; i< ingredients.length; i++){
            System.out.println("\nEnter details for ingredient " + (i + 1));
            ingredients[i].inputIngredient(sc, categories);
        }

        for(int i=0; i < meals.length; i++){
            System.out.println("\nEnter details for meal " + (i + 1));
            meals[i].inputMeal(sc, categories, ingredients);
        }

        for (int i=0; i< chefs.length; i++){
            System.out.println("\nEnter details for chef " + (i + 1));
            chefs[i].inputChefs(sc);
        }

        for (int i=0; i< waiters.length; i++){
            System.out.println("\nEnter details for waiter " + (i + 1));
            waiters[i].inputWaiter(sc);
        }

        for (int i=0; i< deliverers.length; i++){
            System.out.println("\nEnter details for deliverer " + (i + 1));
            deliverers[i].inputDeliverer(sc);
        }

        for (int i = 0; i < restaurants.length; i++) {
            System.out.println("\nEnter details for restaurant " + (i + 1));
            restaurants[i].inputRestaurant(sc, meals, chefs, waiters, deliverers);
        }

        for (int i = 0; i < orders.length; i++) {
            System.out.println("\nEnter details for order " + (i + 1));
            orders[i].inputOrder(sc, restaurants, meals, deliverers, deliveryCounter);
        }

        Order.mostExpensiveOrder(orders);
        Deliverer.mostDelivers(orders, deliveryCounter, deliverers);

    }

}