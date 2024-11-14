package hr.java.restaurant.model;

import java.math.BigDecimal;
import java.util.Scanner;

public class Meal extends Entity {

    private String name;
    private Category category;
    private Ingredient[] ingredients;
    private BigDecimal price;

    public Meal(Long id, String name, Category category, Ingredient[] ingredients, BigDecimal price) {
        super(id);
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.price = price;

        if (ingredients!=null) {
            for (int i = 0; i < ingredients.length; i++) {
                ingredients[i].decreaseQuantity();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Meal inputMeal(Scanner sc, Category[] categories, Ingredient[] ingredients) {
        System.out.println("Enter meal name: ");
        String name = sc.nextLine();

        System.out.println("Enter meal category (index): ");
        for(int j = 0; j< categories.length; j++){
            System.out.println((j + 1) + ". category: " + categories[j].getName());
        }
        int categoryOfMeal = sc.nextInt();
        sc.nextLine();
        while (categoryOfMeal <= 0 || categoryOfMeal > categories.length) {
            System.out.println("Invalid index");
            categoryOfMeal = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Enter number of ingredients for this meal: ");
        int numberOfIngredients = 0;
        do {
            numberOfIngredients = sc.nextInt();
            sc.nextLine();
        } while (numberOfIngredients <= 0);

        Ingredient[] helpIngredients = new Ingredient[numberOfIngredients];

        System.out.println("Pick ingredients for this meal: ");

        for (int k = 0; k < ingredients.length; k++) {
            System.out.println((k + 1) + ". " + ingredients[k].getName());
        }

        for(int j=0; j<numberOfIngredients; j++){
            System.out.println("Pick ingredient number " + (j + 1) + ": ");
            int number = 0;
            do {
                number = sc.nextInt();
                sc.nextLine();
            } while (number <= 0 || number > ingredients.length);
            //ingredients[number - 1].decreaseQuantity();
            helpIngredients[j] = ingredients[number - 1];
        }

        System.out.println("Enter meal price:");
        BigDecimal price = sc.nextBigDecimal();
        sc.nextLine();
        while (price.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid price");
            price = sc.nextBigDecimal();
            sc.nextLine();
        }

        return new Meal(Long.valueOf(1), name, categories[categoryOfMeal - 1], helpIngredients, price);
    }
}
