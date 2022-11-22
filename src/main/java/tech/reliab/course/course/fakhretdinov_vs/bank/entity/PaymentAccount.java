package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

public class PaymentAccount extends Identifier {

    private Long userId;
    private String bankName;
    private long amountOfMoney;

    public PaymentAccount(Long id, Long userId, String bankName, Long amountOfMoney) {
        super(id);
        this.userId = userId;
        this.bankName = bankName;
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + getId() +
                ", userId=" + userId +
                ", bankName='" + bankName + '\'' +
                ", amountOfMoney=" + amountOfMoney +
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

    public Long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

}
