package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import java.util.Date;

public class User {

    private String fullName;
    private Date birthDate;
    private String placeOfWork;
    private Long monthlySalary;
    private Bank bank;
    private CreditAccount creditAccount;
    private PaymentAccount paymentAccount;
    private Integer creditRating;

    public User(String fullName,
                Date birthDate,
                String placeOfWork,
                Long monthlySalary,
                Bank bank,
                CreditAccount creditAccount,
                PaymentAccount paymentAccount,
                Integer creditRating) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.monthlySalary = monthlySalary;
        this.bank = bank;
        this.creditAccount = creditAccount;
        this.paymentAccount = paymentAccount;
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName=" + fullName +
                ", birthDate='" + birthDate + '\'' +
                ", placeOfWork=" + placeOfWork +
                ", monthlySalary='" + monthlySalary + '\'' +
                ", bank=" + bank +
                ", creditAccount=" + creditAccount +
                ", paymentAccount=" + paymentAccount +
                ", creditRating=" + creditRating +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public Long getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Long monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Integer getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Integer creditRating) {
        this.creditRating = creditRating;
    }

}
