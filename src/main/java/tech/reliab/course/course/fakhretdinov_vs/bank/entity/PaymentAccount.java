package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.io.Serializable;

public class PaymentAccount extends Identifier implements Serializable {

    private Long userId;
    private String bankName;
    private long numberOfMoney;

    public PaymentAccount(Long id, Long userId, String bankName, Long numberOfMoney) {
        super(id);
        this.userId = userId;
        this.bankName = bankName;
        this.numberOfMoney = numberOfMoney;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + getId() +
                ", userId=" + userId +
                ", bankName='" + bankName + '\'' +
                ", numberOfMoney=" + numberOfMoney +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getNumberOfMoney() {
        return numberOfMoney;
    }

    public void setNumberOfMoney(Long numberOfMoney) {
        this.numberOfMoney = numberOfMoney;
    }

}
