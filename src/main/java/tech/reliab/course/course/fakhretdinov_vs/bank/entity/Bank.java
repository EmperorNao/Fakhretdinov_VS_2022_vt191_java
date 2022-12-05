package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

public class Bank extends Identifier implements Comparable<Bank> {
    private String name;
    private int numberOfOffices;
    private int numberOfAtms;
    private int numberOfEmployes;
    private int numberOfClients;
    private int bankRating;
    private long numberOfMoney;
    private int interestRate;

    public Bank(Long id,
                String name,
                int numberOfOffices,
                int numberOfAtms,
                int numberOfEmployes,
                int numberOfClients,
                int bankRating,
                long numberOfMoney,
                int interestRate) {
        super(id);
        this.name = name;
        this.numberOfOffices = numberOfOffices;
        this.numberOfAtms = numberOfAtms;
        this.numberOfEmployes = numberOfEmployes;
        this.numberOfClients = numberOfClients;
        this.bankRating = bankRating;
        this.numberOfMoney = numberOfMoney;
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
                ", numberOfMoney=" + numberOfMoney +
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

    public long getNumberOfMoney() {
        return numberOfMoney;
    }

    public void setNumberOfMoney(long numberOfMoney) {
        this.numberOfMoney = numberOfMoney;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public int compareTo(Bank right) {

        if (this.getInterestRate() > right.getInterestRate()) {
            return 1;
        }
        else if (this.getInterestRate() < right.getInterestRate()) {
            return -1;
        }

        if (this.getNumberOfOffices() > right.getNumberOfOffices()) {
            return 1;
        }
        else if (this.getNumberOfOffices() < right.getNumberOfOffices()) {
            return -1;
        }

        if (this.getNumberOfAtms() > right.getNumberOfAtms()) {
            return 1;
        }
        else if (this.getNumberOfAtms() < right.getNumberOfAtms()) {
            return -1;
        }

        if (this.getNumberOfEmployes() > right.getNumberOfEmployes()) {
            return 1;
        }
        else if (this.getNumberOfEmployes() < right.getNumberOfEmployes()) {
            return -1;
        }

        if (this.getNumberOfClients() > right.getNumberOfClients()) {
            return 1;
        }
        else if (this.getNumberOfClients() < right.getNumberOfClients()) {
            return -1;
        }

        return 0;

    }
}


