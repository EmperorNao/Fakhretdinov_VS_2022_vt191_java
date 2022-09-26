package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

public class BankOffice extends Identificator {
    public String name;
    public String address;
    public boolean status;
    public boolean atmCanBePlaced;
    public int numberOfAtms;
    public int creditCanBeIssued;
    public boolean isPaymentingMoney;
    public boolean isDepositingMoney;
    public Currency numberOfMoney;
    public Currency rentPrice;
}
