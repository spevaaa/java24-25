package hr.java.restaurant.model;

import java.math.BigDecimal;
import java.util.Scanner;

public class Deliverer extends Person  {

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
            return new Deliverer(this) {
            };
        }
    }

    public static void inputDeliverer(Deliverer[] deliverers, Scanner scanner) {
        for (int i = 0; i < deliverers.length; i++) {
            System.out.print("Enter " + (i + 1) + ". deliverer's first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter " + (i + 1) + ". deliverer's last name: ");
            String lastName = scanner.nextLine();

            System.out.println("Enter details for " + (i + 1) + ". deliverer's contract:");
            Contract contract = Contract.inputContract(scanner);

            System.out.print("Enter " + (i + 1) + ". deliverer's bonus amount: ");
            BigDecimal bonusAmount = scanner.nextBigDecimal();
            scanner.nextLine();

            Bonus bonus = new Bonus(bonusAmount);

            deliverers[i] = new Deliverer.Builder().withFirstName(firstName).withLastName(lastName).withContract(contract).withBonus(bonus).build();
        }
    }

}