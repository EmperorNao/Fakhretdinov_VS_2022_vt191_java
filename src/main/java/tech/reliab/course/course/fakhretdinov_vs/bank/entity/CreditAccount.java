package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.time.LocalDate;


public class CreditAccount extends Identifier {

    private Long userId;
    private String bankName;
    private LocalDate creditStart;
    private LocalDate creditEnd;
    private int numberOfMonths;
    private Long amountOfMoney;
    private Long monthlyPayment;
    private int interestRate;
    private Long creditEmployeeId;
    private Long paymentAccountId;


    public CreditAccount(Long id,
                         Long user,
                         String bankName,
                         LocalDate creditStart,
                         LocalDate creditEnd,
                         int numberOfMonths,
                         Long amountOfMoney,
                         Long monthlyPayment,
                         int interestRate,
                         Long creditEmployee,
                         Long paymentAccount) {
        super(id);
        this.userId = user;
        this.bankName = bankName;
        this.creditStart = creditStart;
        this.creditEnd = creditEnd;
        this.numberOfMonths = numberOfMonths;
        this.amountOfMoney = amountOfMoney;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.creditEmployeeId = creditEmployee;
        this.paymentAccountId = paymentAccount;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + getId() +
                ", userId=" + userId +
                ", bankName='" + bankName + '\'' +
                ", creditStart=" + creditStart +
                ", creditEnd=" + creditEnd +
                ", numberOfMonths=" + numberOfMonths +
                ", amountOfMoney=" + amountOfMoney +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", creditEmployeeId=" + creditEmployeeId +
                ", paymentAccountId=" + paymentAccountId +
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

    public LocalDate getCreditStart() {
        return creditStart;
    }

    public void setCreditStart(LocalDate creditStart) {
        this.creditStart = creditStart;
    }

    public LocalDate getCreditEnd() {
        return creditEnd;
    }

    public void setCreditEnd(LocalDate creditEnd) {
        this.creditEnd = creditEnd;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    public Long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Long getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public Long getCreditEmployeeId() {
        return creditEmployeeId;
    }

    public void setCreditEmployeeId(Long creditEmployeeId) {
        this.creditEmployeeId = creditEmployeeId;
    }

    public Long getPaymentAccountId() {
        return paymentAccountId;
    }

    public void setPaymentAccountId(Long paymentAccount) {
        this.paymentAccountId = paymentAccountId;
    }

}
