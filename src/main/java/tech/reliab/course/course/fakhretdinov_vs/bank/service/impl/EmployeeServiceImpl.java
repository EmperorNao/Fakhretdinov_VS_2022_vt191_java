package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.EmployeeService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class EmployeeServiceImpl implements EmployeeService {

    private static Long currentMaxId = 0L;
    private static final Random randomGenerator = new Random();
    ServiceContainer<Employee> container = new ServiceContainerImpl<>();

    @Override
    public Employee create(String fullName, String position, Bank bank, LocalDate birthDate, BankOffice office, Long salary) {

        Employee employee = new Employee(
                ++currentMaxId,
                bank.getId(),
                fullName,
                birthDate,
                position,
                randomGenerator.nextBoolean(),
                office.getId(),
                randomGenerator.nextBoolean(),
                salary
        );
        container.update(employee);

        bank.setNumberOfEmployes(bank.getNumberOfEmployes() + 1);
        ServiceManager.getBankService().update(bank);


        return employee;
    }

    @Override
    public Employee get(Long id) {
        return container.get(id);
    }

    @Override
    public ArrayList<Employee> read() {
        Function<Employee, Boolean> trueCondition = obj -> Boolean.TRUE;
        return container.getByCondition(trueCondition);
    }

    @Override
    public void update(Employee obj) {
        container.update(obj);
    }

    @Override
    public void delete(Employee obj) {

        Bank bank = ServiceManager.getBankService().get(obj.getBankId());
        bank.setNumberOfEmployes(bank.getNumberOfEmployes() - 1);
        ServiceManager.getBankService().update(bank);

        container.delete(obj);

    }

    public ArrayList<Employee> getByCondition(Function<Employee, Boolean> condition) {
        return container.getByCondition(condition);
    }



}
