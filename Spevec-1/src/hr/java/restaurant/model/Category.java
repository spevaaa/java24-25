package hr.java.restaurant.model;

import java.util.Scanner;

public class Category extends Entity {

    private String name;
    private String description;

    private Category(Builder builder) {
        super(builder.id);
        this.name = builder.name;
        this.description = builder.description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String description;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }

    public Category inputCategories(Scanner sc){

        System.out.println("Enter category name: ");
        String name = sc.nextLine();

        System.out.println("Enter category description: ");
        String description = sc.nextLine();

        return new Category.Builder().withName(name).withDescription(description).build();
    }
}
