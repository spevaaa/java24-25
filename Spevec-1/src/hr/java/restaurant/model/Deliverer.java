package hr.java.restaurant.model;

import java.math.BigDecimal;
import java.util.Scanner;

public class Deliverer extends Person {

    private String firstName;
    private String lastName;
    private Contract contract;
    private Bonus bonus;

    public Deliverer(Builder builder) {
        super(builder.firstName, builder.lastName);
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contract = builder.contract;
        this.bonus = builder.bonus;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private Contract contract;
        private Bonus bonus;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withContract(Contract contract) {
            this.contract = contract;
            return this;
        }

        public Builder withBonus(Bonus bonus) {
            this.bonus = bonus;
            return this;
        }

        public Deliverer build() {
            return new Deliverer(this);
        }
    }

    public Deliverer inputDeliverer(Scanner sc) {
        System.out.println("Enter deliverers name: ");
        String name = sc.nextLine();

        System.out.println("Enter deliverers last name: ");
        String lastName = sc.nextLine();

        System.out.println("Enter deliverers salary: ");
        BigDecimal salary = sc.nextBigDecimal();
        sc.nextLine();
        while (salary.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid salary");
            salary = sc.nextBigDecimal();
            sc.nextLine();
        }

        return new Deliverer.Builder().withFirstName(name).withLastName(lastName).withContract(contract).build();
    }

    public static void mostDelivers(Order[] orders, int[] delCounter, Deliverer[] deliverers){
        int max = 0;
        int index = 0;
        for (int i = 0; i < delCounter.length; i++) {
            if (delCounter[i] > max) {
                max = delCounter[i];
                index = i;
            }
        }

        System.out.println("\n\nMost delivered order(s) are delivered by:");
        for(int i = index; i< delCounter.length; i++) {
            if(delCounter[i] == max) {
                System.out.println(deliverers[i].getFirstName() + " " + deliverers[i].getLastName());
            }
        }
    }
}
