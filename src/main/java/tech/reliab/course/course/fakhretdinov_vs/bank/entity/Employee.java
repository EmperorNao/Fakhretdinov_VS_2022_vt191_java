package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import java.util.Date;

public class Employee extends Identificator {
    public String fullName;
    public Date birthDate;
    public String position;
    public Bank bank;
    public boolean workingInOffice;
    public BankOffice bankOffice;
    public int creditCanBeIssued;
    public Currency salary;
}
