package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.CreditAccount;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Employee;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.EmployeeService;

import java.util.Date;
import java.util.Random;

public class EmployeeServiceImpl implements EmployeeService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private Employee employee;

    /**
     *
     * @param fullName - имя пользователя
     * @param position - должность пользователя
     * @param bank - банк пользователя
     * @param birthDate - дата рождения пользователя
     * @param office - банковский офис пользователься
     * @param salary - зароботная плата пользователя
     * @return возвращает созданного пользователя
     */
    @Override
    public Employee create(String fullName, String position, Bank bank, Date birthDate, BankOffice office, Long salary) {
        employee = new Employee (
                ++currentMaxId,
                bank,
                fullName,
                birthDate,
                position,
                randomGenerator.nextBoolean(),
                office,
                randomGenerator.nextBoolean(),
                salary
        );

        return employee;
    }

    /**
     *
     * @return возвращает объект сотрудника
     */
    @Override
    public Employee read() {
        return employee;
    }

    /**
     *
     * @param employee - новый сотрудник
     */
    @Override
    public void update(Employee employee) {
        this.employee = employee;
    }

    /**
     *
     * @param employee - сотрудник для удаления
     */
    @Override
    public void delete(Employee employee) {
        if (this.employee == employee) {
            this.employee = null;
        }
    }

}
