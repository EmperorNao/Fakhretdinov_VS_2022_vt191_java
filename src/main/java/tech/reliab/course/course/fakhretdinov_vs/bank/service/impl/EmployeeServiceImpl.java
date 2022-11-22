package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.EmployeeService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;

public class EmployeeServiceImpl implements EmployeeService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private Employee employee;
    ServiceContainer<Employee> container;
    ServiceManager manager;
    public EmployeeServiceImpl() {
        container = new ServiceContainerImpl<Employee>();
    }

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }

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

    @Override
    public ArrayList<Employee> read() {
        Function<Employee, Boolean> always_true = obj -> Boolean.TRUE;
        return container.grep(always_true);
    }

    @Override
    public void update(Employee obj) {
        container.update(obj);
    }

    @Override
    public void delete(Employee obj) {
        container.delete(obj);
    }


}
