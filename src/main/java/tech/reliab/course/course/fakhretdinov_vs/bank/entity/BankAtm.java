package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.enums.BankAtmStatus;

public class BankAtm extends Identificator {
    public String name;
    public String address;
    public BankAtmStatus status;
    public Bank bank;
    // public расположение #TODO -> что значит расположение, если в сущности уже есть адрес
    public Employee serviceEmployee;
    public boolean isPaymentingMoney;
    public boolean isDepositingMoney;
    public Currency numberOfMoney;
    public Currency maintenancePrice;
}
