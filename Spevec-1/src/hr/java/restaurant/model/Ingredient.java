package hr.java.restaurant.model;

import java.math.BigDecimal;
import java.util.Scanner;

public class Ingredient extends Entity {

    private static final int DEFAULT_QUANTITY_ON_STOCK = 5;

    private String name;
    private Category category;
    private BigDecimal kcal;
    private String preparationMethod;
    private Integer quantityOnStock;
    private Integer currentQuantityOnStock;

    public Ingredient(Long id, String name, Category category, BigDecimal kcal, String preparationMethod, Integer quantityOnStock) {
        super(id);
        this.name = name;
        this.category = category;
        this.kcal = kcal;
        this.preparationMethod = preparationMethod;
        this.quantityOnStock = quantityOnStock;
    }

    public Ingredient(Long id, String name, Category category, BigDecimal kcal, String preparationMethod, Integer quantityOnStock, Integer currentQuantityOnStock) {
        super(id);
        this.name = name;
        this.category = category;
        this.kcal = kcal;
        this.preparationMethod = preparationMethod;
        this.quantityOnStock = quantityOnStock;
        this.currentQuantityOnStock = currentQuantityOnStock;
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

    public BigDecimal getKcal() {
        return kcal;
    }

    public void setKcal(BigDecimal kcal) {
        this.kcal = kcal;
    }

    public String getPreparationMethod() {
        return preparationMethod;
    }

    public void setPreparationMethod(String preparationMethod) {
        this.preparationMethod = preparationMethod;
    }

    public Integer getQuantityOnStock() {
        return quantityOnStock;
    }

    public void setQuantityOnStock(Integer quantityOnStock) {
        this.quantityOnStock = quantityOnStock;
    }

    public Integer getCurrentQuantityOnStock() {
        return currentQuantityOnStock;
    }

    public void setCurrentQuantityOnStock(Integer currentQuantityOnStock) {
        this.currentQuantityOnStock = currentQuantityOnStock;
    }

    public void decreaseQuantity(){
        if (currentQuantityOnStock == 0) {
            System.out.println("Current quantity is zero!");
        } else currentQuantityOnStock--;
    }

    public Ingredient inputIngredient(Scanner sc, Category[] categories) {

        System.out.println("Enter ingredient name: ");
        String name = sc.nextLine();

        System.out.println("Enter max quantity on stock: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter ingredient category (index): ");
        for (int j = 0; j < categories.length; j++) {
            System.out.println((j + 1) + ". category: " + categories[j].getName());
        }
        int categoryOfIngredient = sc.nextInt();
        sc.nextLine();
        while (categoryOfIngredient <= 0 || categoryOfIngredient > categories.length) {
            System.out.println("Invalid index");
            categoryOfIngredient = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Enter ingredient calories: ");
        BigDecimal calories = sc.nextBigDecimal();
        sc.nextLine();

        System.out.println("Enter ingredient preparation method: ");
        String preparationMethod = sc.nextLine();

        return new Ingredient(Long.valueOf(1), name, categories[categoryOfIngredient - 1], calories, preparationMethod, quantity);
    }
}
