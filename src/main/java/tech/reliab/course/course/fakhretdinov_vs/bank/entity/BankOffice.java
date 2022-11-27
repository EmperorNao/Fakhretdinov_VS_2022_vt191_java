package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

public class BankOffice extends Identifier {

    private Long bankId;
    private String name;
    private String address;
    private boolean status;
    private boolean atmCanBePlaced;
    private int numberOfAtms;
    private boolean creditCanBeIssued;
    private boolean isPaymentingMoney;
    private boolean isDepositingMoney;
    private long numberOfMoney;
    private long rentPrice;


    public BankOffice(Long id,
                      Long bankId,
                      String name,
                      String address,
                      boolean status,
                      boolean atmCanBePlaced,
                      int numberOfAtms,
                      boolean creditCanBeIssued,
                      boolean isPaymentingMoney,
                      boolean isDepositingMoney,
                      long numberOfMoney,
                      long rentPrice) {
        super(id);
        this.bankId = bankId;
        this.name = name;
        this.address = address;
        this.status = status;
        this.atmCanBePlaced = atmCanBePlaced;
        this.numberOfAtms = numberOfAtms;
        this.creditCanBeIssued = creditCanBeIssued;
        this.isPaymentingMoney = isPaymentingMoney;
        this.isDepositingMoney = isDepositingMoney;
        this.numberOfMoney = numberOfMoney;
        this.rentPrice = rentPrice;
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "id=" + getId() +
                ", bankId=" + bankId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", atmCanBePlaced=" + atmCanBePlaced +
                ", numberOfAtms=" + numberOfAtms +
                ", creditCanBeIssued=" + creditCanBeIssued +
                ", isPaymentingMoney=" + isPaymentingMoney +
                ", isDepositingMoney=" + isDepositingMoney +
                ", numberOfMoney=" + numberOfMoney +
                ", rentPrice=" + rentPrice +
                '}';
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getAtmCanBePlaced() {
        return atmCanBePlaced;
    }

    public void setAtmCanBePlaced(boolean atmCanBePlaced) {
        this.atmCanBePlaced = atmCanBePlaced;
    }

    public int getNumberOfAtms() {
        return numberOfAtms;
    }

    public void setNumberOfAtms(int numberOfAtms) {
        this.numberOfAtms = numberOfAtms;
    }

    public boolean getCreditCanBeIssued() {
        return creditCanBeIssued;
    }

    public void setCreditCanBeIssued(boolean creditCanBeIssued) {
        this.creditCanBeIssued = creditCanBeIssued;
    }

    public boolean getPaymentingMoney() {
        return isPaymentingMoney;
    }

    public void setPaymentingMoney(boolean paymentingMoney) {
        isPaymentingMoney = paymentingMoney;
    }

    public boolean getDepositingMoney() {
        return isDepositingMoney;
    }

    public void setDepositingMoney(boolean depositingMoney) {
        isDepositingMoney = depositingMoney;
    }

    public long getNumberOfMoney() {
        return numberOfMoney;
    }

    public void setNumberOfMoney(long numberOfMoney) {
        this.numberOfMoney = numberOfMoney;
    }

    public long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(long rentPrice) {
        this.rentPrice = rentPrice;
    }

}
