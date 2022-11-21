package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

public class PaymentAccount extends Identifier {

    private User user;
    private String bankName;
    private long amountOfMoney;

    public PaymentAccount(Long id, User user, String bankName, Long amountOfMoney) {
        super(id);
        this.user = user;
        this.bankName = bankName;
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + this.getId() +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

}
