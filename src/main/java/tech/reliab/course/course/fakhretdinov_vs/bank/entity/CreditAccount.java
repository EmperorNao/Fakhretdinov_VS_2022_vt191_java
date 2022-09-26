package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

public class CreditAccount {
    public int id;
    public User user;
    public String bankName;
    public long creditStartTimestamp;
    public long creditEndTimestamp;
    public int numberOfMonths;
    public int amountOfMoney;
    public int monthlyPayment;
    public int interestRate;
    public Employee creditEmployee;
    public PaymentAccount paymentAccount;
}
