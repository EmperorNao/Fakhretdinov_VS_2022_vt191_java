package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

public class Bank {
    private Long id;
    private String name;
    private Integer numberOfOffices;
    private Integer numberOfAtms;
    private Integer numberOfEmployes;
    private Integer numberOfClients;
    private Integer bankRating;
    private Long amountOfMoney;
    private Integer interestRate;

    public Bank(Long id,
                String name,
                Integer numberOfOffices,
                Integer numberOfAtms,
                Integer numberOfEmployes,
                Integer numberOfClients,
                Integer bankRating,
                Long amountOfMoney,
                Integer interestRate) {
        this.id = id;
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
                "id=" + id +
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfOffices() {
        return numberOfOffices;
    }

    public void setNumberOfOffices(Integer numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }

    public Integer getNumberOfAtms() {
        return numberOfAtms;
    }

    public void setNumberOfAtms(Integer numberOfAtms) {
        this.numberOfAtms = numberOfAtms;
    }

    public Integer getNumberOfEmployes() {
        return numberOfEmployes;
    }

    public void setNumberOfEmployes(Integer numberOfEmployes) {
        this.numberOfEmployes = numberOfEmployes;
    }

    public Integer getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(Integer numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public Integer getBankRating() {
        return bankRating;
    }

    public void setBankRating(Integer bankRating) {
        this.bankRating = bankRating;
    }

    public Long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

}


