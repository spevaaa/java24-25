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


        Category.inputCategory(categories, sc);
        Ingredient.inputIngredient(ingredients, categories, sc);
        Meal.inputMeal(meals, categories, ingredients, sc);
        Chef.inputChef(chefs, sc);
        Waiter.inputWaiter(waiters, sc);
        Deliverer.inputDeliverer(deliverers, sc);
        Restaurant.inputRestaurant(restaurants, meals, chefs, waiters, deliverers, sc);
        Order.inputOrder(orders, restaurants, meals, chefs, deliverers, sc);

    }
}