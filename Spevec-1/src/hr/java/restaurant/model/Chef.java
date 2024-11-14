package hr.java.restaurant.model;

import java.math.BigDecimal;
import java.util.Scanner;

public class Chef extends Person {

    private String firstName;
    private String lastName;
    private Contract contract;
    private Bonus bonus;

    private Chef(Builder builder) {
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

    public static class Builder {
        private String firstName;
        private String lastName;
        private Contract contract;
        private Bonus bonus;

        public Builder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder withContract(Contract contract){
            this.contract = contract;
            return this;
        }

        public Builder withBonus(Bonus bonus){
            this.bonus = bonus;
            return this;
        }

        public Chef build() {
            return new Chef(this);
        }

    }

    public Chef inputChefs(Scanner sc) {
        System.out.println("Enter chefs name: ");
        String name = sc.nextLine();

        System.out.println("Enter chefs last name: ");
        String lastName = sc.nextLine();

        System.out.println("Enter chefs salary: ");
        BigDecimal salary = sc.nextBigDecimal();
        sc.nextLine();
        while (salary.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid salary");
            salary = sc.nextBigDecimal();
            sc.nextLine();
        }

        return new Chef.Builder().withFirstName(firstName).withLastName(lastName).withContract(contract).build();
    }
}
