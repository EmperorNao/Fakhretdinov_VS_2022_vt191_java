package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class BankServiceImpl implements BankService {

    private Long currentMaxId = 0L;
    private static final Random randomGenerator = new Random();
    ServiceContainer<Bank> container = new ServiceContainerImpl<>();

    @Override
    public Bank create(String name) {

        int rating = randomGenerator.nextInt(100);
        int rate = 20 -  Math.toIntExact(Math.round(20 * rating / 100.0));
        long money = randomGenerator.nextLong(1_000_000L);
        Bank bank = new Bank(
                currentMaxId++,
                name,
                0,
                0,
                0,
                0,
                rating,
                money,
                rate
        );
        container.update(bank);

        return bank;

    }

    @Override
    public Bank get(Long id) {
        return container.get(id);
    }

    @Override
    public ArrayList<Bank> read() {
        Function<Bank, Boolean> trueCondition = obj -> Boolean.TRUE;
        return container.getByCondition(trueCondition);
    }

    @Override
    public void update(Bank obj) {
        container.update(obj);
    }

    @Override
    public void delete(Bank obj) {
        container.delete(obj);
    }

    @Override
    public ArrayList<Bank> getByCondition(Function<Bank, Boolean> condition) {
        return container.getByCondition(condition);
    }

    @Override
    public boolean isClient(Bank bank, User user) {

        Function<PaymentAccount, Boolean> checkPaymentAcc = acc -> acc.getBankName().equals(bank.getName());
        Function<CreditAccount, Boolean> checkCreditAcc = acc -> acc.getBankName().equals(bank.getName());

        ArrayList<PaymentAccount> paymentAccounts = ServiceManager.getPaymentAccountService().getByCondition(checkPaymentAcc);
        ArrayList<CreditAccount> creditAccounts = ServiceManager.getCreditAccountService().getByCondition(checkCreditAcc);

        for (PaymentAccount acc: paymentAccounts) {
            if (acc.getUserId().equals(user.getId())) {
                return Boolean.TRUE;
            }
        }

        for (CreditAccount acc: creditAccounts) {
            if (acc.getUserId().equals(user.getId())) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;

    }

    public void printBankInfo(Bank bank) {

        Function<BankOffice, Boolean> checkOffice = office -> office.getBankId().equals(bank.getId());
        ArrayList<BankOffice> offices = ServiceManager.getBankOfficeService().getByCondition(checkOffice);

        Function<BankAtm, Boolean> checkAtm = atm -> atm.getBankId().equals(bank.getId());
        ArrayList<BankAtm> atms = ServiceManager.getBankAtmService().getByCondition(checkAtm);

        Function<Employee, Boolean> checkEmployee = employee -> employee.getBankId().equals(bank.getId());
        ArrayList<Employee> employees = ServiceManager.getEmployeeService().getByCondition(checkEmployee);

        ArrayList<User> users = new ArrayList<>();
        ArrayList<User> allUsers = ServiceManager.getUserService().read();

        for (User user: allUsers) {

            if (this.isClient(bank, user)) {
                users.add(user);
            }

        }

        System.out.println("Bank:");
        System.out.println(bank);

        System.out.println();
        System.out.println("Offices:");
        for (BankOffice office: offices) {
            System.out.println(office);
        }

        System.out.println();
        System.out.println("Atms:");
        for (BankAtm atm: atms) {
            System.out.println(atm);
        }

        System.out.println();
        System.out.println("Employees:");
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.println("Users:");
        for (User user: users) {
            System.out.println(user);
        }

    }

}
