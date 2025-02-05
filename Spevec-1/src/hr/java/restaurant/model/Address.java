package hr.java.restaurant.model;

import java.util.Scanner;

public class Address extends Entity {
    private String street;
    private String houseNumber;
    private String city;
    private String postalCode;

    public Address(Builder builder) {
        super(builder.id);
        this.street = builder.street;
        this.houseNumber = builder.houseNumber;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public static class Builder{
        private Long id;
        private String street;
        private String houseNumber;
        private String city;
        private String postalCode;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }

    public Address inputAddress(Scanner scanner) {
        System.out.println("Enter street: ");
        String street = scanner.nextLine();

        System.out.println("Enter house number: ");
        String houseNumber = scanner.nextLine();

        System.out.println("Enter city: ");
        String city = scanner.nextLine();

        System.out.println("Enter postal code: ");
        String postalCode = scanner.nextLine();

        return new Address.Builder().withStreet(street).withHouseNumber(houseNumber).withCity(city).withPostalCode(postalCode).build();
    }
}
