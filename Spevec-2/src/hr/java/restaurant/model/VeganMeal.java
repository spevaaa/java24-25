package hr.java.restaurant.model;

import java.math.BigDecimal;

public final class VeganMeal extends Meal implements Vegan {
    private boolean isGlutenFree;

    public VeganMeal(Long id, String name, Category category, Ingredient[] ingredients, BigDecimal price, boolean isGlutenFree) {
        super(id, name, category, ingredients, price);
        this.isGlutenFree = isGlutenFree;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    @Override
    public boolean isOrganic() {
        return true;
    }

    @Override
    public int calories() {
        return 200;
    }

}