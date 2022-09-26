package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

public class BankAtm {
    public int id;
    public String name;
    public String address;
    public BankAtmStatus status;
    public Bank bank;
    //public РАСПОЛОЖЕНИЕ
    public Employee serviceEmployee;
    public boolean isPaymentingMoney;
    public boolean isDepositingMoney;
    public int numberOfMoney;
    public int maintenancePrice;
}
