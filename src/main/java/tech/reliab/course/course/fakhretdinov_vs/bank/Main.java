package tech.reliab.course.course.fakhretdinov_vs.bank;


import tech.reliab.course.course.fakhretdinov_vs.bank.service.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;

import java.time.Instant;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ServiceManager manager = new ServiceManager(new BankServiceImpl(),
                new BankAtmServiceImpl(),
                new BankOfficeServiceImpl(),
                new EmployeeServiceImpl(),
                new UserServiceImpl(),
                new CreditAccountServiceImpl(),
                new PaymentAccountServiceImpl());


        // сервисы
        BankService bankService = manager.bankService;
        BankAtmService atmService = manager.bankAtmService;
        BankOfficeService bankOfficeService = manager.bankOfficeService;
        EmployeeService employeeService = manager.employeeService;
        UserService userService = manager.userService;
        CreditAccountService creditAccountService = manager.creditAccountService;
        PaymentAccountService paymentAccountService = manager.paymentAccountService;


        // создаем банк
        var bank = bankService.create("НЕНАВИЖУ");

        // создаем офис
        var bankOffice = bankOfficeService.create("НЕНАВИЖУ", bank, "НЕНАВИЖУ 2", 0L);

        // создаем работника
        var employee = employeeService.create("НЕНАВИЖУ",
                "НЕНАВИЖУ 2",
                bank,
                Date.from(Instant.now()),
                bankOffice,
                1L);

        // создаем банкомат
        var atm = atmService.create("НЕНАВИЖУ", bank, bankOffice, employee);

        // создаем клиента
        var user = userService.create("НЕНАВИЖУ", Date.from(Instant.now()), "НЕНАВИЖУ 2", bank);

        var paymentAccount = paymentAccountService.create(user, bank);

        var creditAccount = creditAccountService.create(user, bank,
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                1,
                0L,
                0L,
                employee,
                paymentAccount);

        System.out.println(bank);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(atm);
        System.out.println(user);
        System.out.println(creditAccount);
        System.out.println(paymentAccount);

    }

}
