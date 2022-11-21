package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.util.Date;

public class CreditAccount extends Identifier {

    private User user;
    private String bankName;
    private Date creditStart;
    private Date creditEnd;
    private Integer numberOfMonths;
    private Long amountOfMoney;
    private Long monthlyPayment;
    private Integer interestRate;
    private Employee creditEmployee;
    private PaymentAccount paymentAccount;


    public CreditAccount(Long id,
                         User user,
                         String bankName,
                         Date creditStart,
                         Date creditEnd,
                         Integer numberOfMonths,
                         Long amountOfMoney,
                         Long monthlyPayment,
                         Integer interestRate,
                         Employee creditEmployee,
                         PaymentAccount paymentAccount) {
        super(id);
        this.user = user;
        this.bankName = bankName;
        this.creditStart = creditStart;
        this.creditEnd = creditEnd;
        this.numberOfMonths = numberOfMonths;
        this.amountOfMoney = amountOfMoney;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.creditEmployee = creditEmployee;
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + this.getId() +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", creditStart=" + creditStart +
                ", creditEnd=" + creditEnd +
                ", numberOfMonths=" + numberOfMonths +
                ", amountOfMoney=" + amountOfMoney +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", creditEmployee=" + creditEmployee +
                ", paymentAccount=" + paymentAccount +
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

    public Date getCreditStart() {
        return creditStart;
    }

    public void setCreditStart(Date creditStart) {
        this.creditStart = creditStart;
    }

    public Date getCreditEnd() {
        return creditEnd;
    }

    public void setCreditEnd(Date creditEnd) {
        this.creditEnd = creditEnd;
    }

    public Integer getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(Integer numberOfMonths) {
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

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public Employee getCreditEmployee() {
        return creditEmployee;
    }

    public void setCreditEmployee(Employee creditEmployee) {
        this.creditEmployee = creditEmployee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

}
