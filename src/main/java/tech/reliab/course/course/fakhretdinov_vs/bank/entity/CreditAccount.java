package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.time.LocalDate;


public class CreditAccount extends Identifier {

    private Long userId;
    private String bankName;
    private LocalDate creditStart;
    private LocalDate creditEnd;
    private int numberOfMonths;
    private long numberOfMoney;
    private long monthlyPayment;
    private int interestRate;
    private long creditEmployeeId;
    private long paymentAccountId;


    public CreditAccount(Long id,
                         Long user,
                         String bankName,
                         LocalDate creditStart,
                         LocalDate creditEnd,
                         int numberOfMonths,
                         long numberOfMoney,
                         long monthlyPayment,
                         int interestRate,
                         long creditEmployee,
                         long paymentAccount) {
        super(id);
        this.userId = user;
        this.bankName = bankName;
        this.creditStart = creditStart;
        this.creditEnd = creditEnd;
        this.numberOfMonths = numberOfMonths;
        this.numberOfMoney = numberOfMoney;
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
                ", numberOfMoney=" + numberOfMoney +
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

    public long getNumberOfMoney() {
        return numberOfMoney;
    }

    public void setNumberOfMoney(long numberOfMoney) {
        this.numberOfMoney = numberOfMoney;
    }

    public long getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(long monthlyPayment) {
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
        this.paymentAccountId = paymentAccount;
    }

}
