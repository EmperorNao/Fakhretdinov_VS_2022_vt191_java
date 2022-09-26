package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import java.util.Date;

public class CreditAccount extends Identificator {
    public User user;
    public String bankName;
    public Date creditStart;
    public Date creditEnd;
    public int numberOfMonths;
    public Currency amountOfMoney;
    public Currency monthlyPayment;
    public int interestRate;
    public Employee creditEmployee;
    public PaymentAccount paymentAccount;
}
