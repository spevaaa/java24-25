package hr.java.restaurant.model;

import java.math.BigDecimal;

public final class MeatMeal extends Meal implements Meat {
    private boolean isMarinated;

    public MeatMeal(Long id, String name, Category category, Ingredient[] ingredients, BigDecimal price, boolean isMarinated) {
        super(id, name, category, ingredients, price);
        this.isMarinated = isMarinated;
    }

    public boolean isMarinated() {
        return isMarinated;
    }

    public void setMarinated(boolean marinated) {
        isMarinated = marinated;
    }

    @Override
    public boolean isGrilled() {
        return true;
    }

    @Override
    public String meatType() {
        return "Chicken";
    }
}