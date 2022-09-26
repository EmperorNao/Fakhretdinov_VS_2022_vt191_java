package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import java.util.Date;

public class User extends Identificator {
    public String fullName;
    public Date birthDate;
    public String placeOfWork;
    public Currency monthlySalary;
    public Bank bank;
    public CreditAccount creditAccount;
    public PaymentAccount paymentAccount;
    public int creditRating;
}
