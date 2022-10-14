package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Employee;

public interface BankOfficeService {
    BankOffice create(String name, Bank bank, String address, Long rentPrice);
    BankOffice read();
    void update(BankOffice bankOffice);
    void delete(BankOffice bankOffice);
}
