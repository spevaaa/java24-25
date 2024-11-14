package hr.java.restaurant.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Contract {
    private final String fullTime = "FULL_TIME";
    private final String partTime = "PART_TIME";

    private BigDecimal salary;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String typeOfContract;

    public Contract(BigDecimal salary, LocalDateTime startDate, LocalDateTime endDate, String typeOfContract) {
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeOfContract = typeOfContract;
    }

    public String getFullTime() {
        return fullTime;
    }

    public String getPartTime() {
        return partTime;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }
}
