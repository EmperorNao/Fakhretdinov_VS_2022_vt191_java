package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Employee;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;

import java.time.LocalDate;
import java.util.ArrayList;

public interface EmployeeService extends Service<Employee> {
    Employee create(String fullName, String position, Bank bank, LocalDate birthDate, BankOffice office, long salary);
    Employee get(Long id) throws WrongIdentifierHandlingException;
    ArrayList<Employee> read();

}
