package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

public class Bank extends Identifier {
    private String name;
    private int numberOfOffices;
    private int numberOfAtms;
    private int numberOfEmployes;
    private int numberOfClients;
    private int bankRating;
    private Long amountOfMoney;
    private int interestRate;

    public Bank(Long id,
                String name,
                int numberOfOffices,
                int numberOfAtms,
                int numberOfEmployes,
                int numberOfClients,
                int bankRating,
                Long amountOfMoney,
                int interestRate) {
        super(id);
        this.name = name;
        this.numberOfOffices = numberOfOffices;
        this.numberOfAtms = numberOfAtms;
        this.numberOfEmployes = numberOfEmployes;
        this.numberOfClients = numberOfClients;
        this.bankRating = bankRating;
        this.amountOfMoney = amountOfMoney;
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", numberOfOffices=" + numberOfOffices +
                ", numberOfAtms=" + numberOfAtms +
                ", numberOfEmployes=" + numberOfEmployes +
                ", numberOfClients=" + numberOfClients +
                ", bankRating=" + bankRating +
                ", amountOfMoney=" + amountOfMoney +
                ", interestRate=" + interestRate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfOffices() {
        return numberOfOffices;
    }

    public void setNumberOfOffices(int numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }

    public int getNumberOfAtms() {
        return numberOfAtms;
    }

    public void setNumberOfAtms(int numberOfAtms) {
        this.numberOfAtms = numberOfAtms;
    }

    public int getNumberOfEmployes() {
        return numberOfEmployes;
    }

    public void setNumberOfEmployes(int numberOfEmployes) {
        this.numberOfEmployes = numberOfEmployes;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public int getBankRating() {
        return bankRating;
    }

    public void setBankRating(int bankRating) {
        this.bankRating = bankRating;
    }

    public Long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

}


