package hr.java.restaurant.model;

import java.math.BigDecimal;

public final class VegetarianMeal extends Meal implements Vegetarian {
    private boolean isSpicy;


    public VegetarianMeal(Long id, String name, Category category, Ingredient[] ingredients, BigDecimal price, boolean isSpicy) {
        super(id, name, category, ingredients, price);
        this.isSpicy = isSpicy;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    @Override
    public boolean isDairyFree() {
        return !isSpicy;
    }

    @Override
    public String servingTemperature() {
        return "Hot";
    }

}