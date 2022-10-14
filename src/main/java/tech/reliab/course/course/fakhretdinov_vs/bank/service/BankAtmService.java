package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankAtm;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Employee;

public interface BankAtmService {
    BankAtm create(String name, Bank bank, BankOffice office, Employee employee);
    BankAtm read();
    void update(BankAtm bankAtm);
    void delete(BankAtm bankAtm);
}
