package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

public class BankOffice extends Identifier {

    private Long bankId;
    private String name;
    private String address;
    private Boolean status;
    private Boolean atmCanBePlaced;
    private Integer numberOfAtms;
    private Boolean creditCanBeIssued;
    private Boolean isPaymentingMoney;
    private Boolean isDepositingMoney;
    private Long numberOfMoney;
    private Long rentPrice;


    public BankOffice(Long id,
                      Long bankId,
                      String name,
                      String address,
                      Boolean status,
                      Boolean atmCanBePlaced,
                      Integer numberOfAtms,
                      Boolean creditCanBeIssued,
                      Boolean isPaymentingMoney,
                      Boolean isDepositingMoney,
                      Long numberOfMoney,
                      Long rentPrice) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getAtmCanBePlaced() {
        return atmCanBePlaced;
    }

    public void setAtmCanBePlaced(Boolean atmCanBePlaced) {
        this.atmCanBePlaced = atmCanBePlaced;
    }

    public Integer getNumberOfAtms() {
        return numberOfAtms;
    }

    public void setNumberOfAtms(Integer numberOfAtms) {
        this.numberOfAtms = numberOfAtms;
    }

    public Boolean getCreditCanBeIssued() {
        return creditCanBeIssued;
    }

    public void setCreditCanBeIssued(Boolean creditCanBeIssued) {
        this.creditCanBeIssued = creditCanBeIssued;
    }

    public Boolean getPaymentingMoney() {
        return isPaymentingMoney;
    }

    public void setPaymentingMoney(Boolean paymentingMoney) {
        isPaymentingMoney = paymentingMoney;
    }

    public Boolean getDepositingMoney() {
        return isDepositingMoney;
    }

    public void setDepositingMoney(Boolean depositingMoney) {
        isDepositingMoney = depositingMoney;
    }

    public Long getNumberOfMoney() {
        return numberOfMoney;
    }

    public void setNumberOfMoney(Long numberOfMoney) {
        this.numberOfMoney = numberOfMoney;
    }

    public Long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }

}
