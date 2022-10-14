package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Employee;

import java.util.Date;

public interface EmployeeService {
    Employee create(String fullName, String position, Bank bank, Date birthDate, BankOffice office, Long salary);
    Employee read();
    void update(Employee employee);
    void delete(Employee employee);
}
