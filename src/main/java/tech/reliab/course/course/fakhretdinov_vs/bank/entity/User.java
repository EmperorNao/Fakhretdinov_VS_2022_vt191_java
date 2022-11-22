package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.util.ArrayList;
import java.util.Date;

public class User extends Identifier {

    private String fullName;
    private Date birthDate;
    private String placeOfWork;
    private Long monthlySalary;
    private ArrayList<Bank> banks;
    private ArrayList<CreditAccount> creditAccounts;
    private ArrayList<PaymentAccount> paymentAccounts;
    private Integer creditRating;

    public User(Long id,
                String fullName,
                Date birthDate,
                String placeOfWork,
                Long monthlySalary,
//                ArrayList<Bank> banks,
//                ArrayList<CreditAccount> creditAccounts,
//                ArrayList<PaymentAccount> paymentAccounts,
                Integer creditRating) {
        super(id);
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.monthlySalary = monthlySalary;
//        this.banks = banks;
//        this.creditAccounts = creditAccounts;
//        this.paymentAccounts = paymentAccounts;
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", fullName=" + fullName +
                ", birthDate='" + birthDate + '\'' +
                ", placeOfWork=" + placeOfWork +
                ", monthlySalary='" + monthlySalary + '\'' +
                ", banks=" + banks +
                ", creditAccounts=" + creditAccounts +
                ", paymentAccounts=" + paymentAccounts +
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

//    public ArrayList<Bank> getBanks() {
//        return banks;
//    }
//
//    public void setBanks(ArrayList<Bank> banks) {
//        this.banks = banks;
//    }
//
//    public ArrayList<CreditAccount> getCreditAccounts() {
//        return creditAccounts;
//    }
//
//    public void setCreditAccounts(ArrayList<CreditAccount> creditAccounts) {
//        this.creditAccounts = creditAccounts;
//    }
//
//    public ArrayList<PaymentAccount> getPaymentAccounts() {
//        return paymentAccounts;
//    }
//
//    public void setPaymentAccounts(ArrayList<PaymentAccount> paymentAccount) {
//        this.paymentAccounts = paymentAccounts;
//    }

    public Integer getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Integer creditRating) {
        this.creditRating = creditRating;
    }

}
